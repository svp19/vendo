package com.alphawallet.app.ui;


import static android.app.Activity.RESULT_OK;
import static org.web3j.crypto.Bip32ECKeyPair.HARDENED_BIT;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.security.keystore.UserNotAuthenticatedException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.ViewModelProvider;

import com.alphawallet.app.BuildConfig;
import com.alphawallet.app.R;
import com.alphawallet.app.entity.Wallet;
import com.alphawallet.app.entity.WalletPage;
import com.alphawallet.app.entity.cryptokeys.KeyServiceException;
import com.alphawallet.app.repository.RetrofitClient;
import com.alphawallet.app.repository.entity.UploadAdResultData;
import com.alphawallet.app.util.LocaleUtils;
import com.alphawallet.app.util.Web3jFactory;
import com.alphawallet.app.viewmodel.NewUploadAdViewModel;
import com.alphawallet.app.viewmodel.NewUploadAdViewModelFactory;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import org.web3j.crypto.Bip32ECKeyPair;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.MnemonicUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.infura.InfuraHttpService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Enumeration;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import java8.util.concurrent.CompletableFuture;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class NewUploadAdFragment extends BaseFragment {
    private static final int MY_CAMERA_PERMISSION_CODE = 2;
    private static final int UPLOAD_FROM_GALLERY = 564;
    private static final int CAMERA_REQUEST = 565;
    private Wallet currentWallet;

    @Inject
    NewUploadAdViewModelFactory newUploadAdViewModelFactory;

    private NewUploadAdViewModel viewModel;
    private ImageButton uploadFromCamera;
    private ImageButton uploadFromGallery;
    private ImageView imageContainer;
    private Button uploadButton;
    private Bitmap imageToUpload;
    private TextInputEditText posterAddressTF;
    private TextInputEditText redirectUrlTF;
    private TextInputEditText tagaTF;
    private ProgressBar progressBar;

    private Wallet wallet;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        viewModel = new ViewModelProvider(this, newUploadAdViewModelFactory)
                .get(NewUploadAdViewModel.class);

        LocaleUtils.setActiveLocale(getContext());

        View view = inflater.inflate(R.layout.fragment_upload, container, false);

        uploadFromCamera = view.findViewById(R.id.upload_camera);
        uploadFromGallery = view.findViewById(R.id.upload_gallery);
        imageContainer = view.findViewById(R.id.uploaded_image_container);
        uploadButton = view.findViewById(R.id.upload_button);

        posterAddressTF = view.findViewById(R.id.upload_address);
        redirectUrlTF = view.findViewById(R.id.redirect_url);
        tagaTF = view.findViewById(R.id.upload_tags);
        progressBar = view.findViewById(R.id.progress_bar_upload);

        toolbar(view);

        setUpListeners();

        viewModel.defaultWallet().observe(getActivity(), wallet1 -> {
            this.currentWallet = wallet1;
        });

        setToolbarTitle(R.string.toolbar_header_upload);
        return view;
    }

    private void setUpListeners() {
        uploadFromGallery.setOnClickListener(v -> {
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, UPLOAD_FROM_GALLERY);
        });

        uploadFromCamera.setOnClickListener(v -> {
            if (getActivity().checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
            } else {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        uploadButton.setOnClickListener(v -> {
            if (imageToUpload != null) {
                progressBar.setVisibility(View.VISIBLE);
                getSuperHeroes();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == UPLOAD_FROM_GALLERY && resultCode == RESULT_OK && null != data) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getActivity().getContentResolver().openInputStream(imageUri);
                imageToUpload = getResizedBitmap(BitmapFactory.decodeStream(imageStream), 400);

                imageContainer.setImageBitmap(imageToUpload);
                imageContainer.setBackground(null);
                imageContainer.setPadding(0, 0, 0, 0);
                uploadButton.setEnabled(true);
                uploadButton.setBackground(AppCompatResources.getDrawable(getActivity(), R.drawable.button_default));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            imageToUpload = (Bitmap) data.getExtras().get("data");
            imageContainer.setImageBitmap(imageToUpload);
            imageContainer.setBackground(null);
            imageContainer.setPadding(0, 0, 0, 0);
            uploadButton.setEnabled(true);
            uploadButton.setBackground(AppCompatResources.getDrawable(getActivity(), R.drawable.button_default));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                Toast.makeText(getActivity(), "Please provide us camera permission", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (viewModel == null) {
            ((HomeActivity) getActivity()).resetFragment(WalletPage.UPLOAD_AD);
        } else {
            viewModel.prepare();
        }
    }

    private String getPrivateKeyFromMnemonic(String mnemonic) {
        int[] path = {44 | HARDENED_BIT, 60 | HARDENED_BIT, 0 | HARDENED_BIT, 0, 0};

        byte[] seed = MnemonicUtils.generateSeed(mnemonic, "");

        Bip32ECKeyPair masterKeyPair = Bip32ECKeyPair.generateKeyPair(seed);

        Bip32ECKeyPair bip44Keypair = Bip32ECKeyPair.deriveKeyPair(masterKeyPair, path);

        Credentials credentials = Credentials.create(bip44Keypair);

        return credentials.getAddress();

    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

    private void getSuperHeroes() {

        try {
            if (currentWallet != null) {
                String mnemonic = unpackMnemonic(currentWallet);

                String privateKey = getPrivateKeyFromMnemonic(mnemonic);
                Log.d("sonusourav", "private key " + privateKey);

            }
        } catch (UserNotAuthenticatedException e) {
            e.printStackTrace();
        } catch (KeyServiceException e) {
            e.printStackTrace();
        }
        File f = new File(getActivity().getCacheDir(), "image");
        try {
            f.createNewFile();
        } catch (IOException exception) {
            Timber.d("error %s", exception.getLocalizedMessage());
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        imageToUpload.compress(Bitmap.CompressFormat.JPEG, 0 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (fos != null) {
                fos.write(bitmapdata);
                fos.flush();
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), f);
        MultipartBody.Part image = MultipartBody.Part.createFormData("file", f.getName(), reqFile);

        String posterAddress = posterAddressTF.getText().toString();
        if (posterAddress.isEmpty()) {
            posterAddress = "0x71C7656EC7ab88b098defB751B7401B5f6d8976F";
        }
        int maxToken = 150;
        String redirectUrl = redirectUrlTF.getText().toString();
        if (redirectUrl.isEmpty()) {
            redirectUrl = "https://twitter.com/analyticaldosa";
        }
        String tagData = tagaTF.getText().toString();
        if (tagData.isEmpty()) {
            tagData = "DosaTime|AnalyticalWhat?|";
        }

        RequestBody posterAddressReq = RequestBody.create(okhttp3.MultipartBody.FORM, posterAddress);
        RequestBody maxTokenReq = RequestBody.create(okhttp3.MultipartBody.FORM, String.valueOf(maxToken));
        RequestBody redirectUrlReq = RequestBody.create(okhttp3.MultipartBody.FORM, redirectUrl);
        RequestBody tagDataReq = RequestBody.create(okhttp3.MultipartBody.FORM, tagData);

        Call<UploadAdResultData> call = RetrofitClient.getInstance().getVendoApi().uploadAd(image,
                posterAddressReq,
                maxTokenReq,
                redirectUrlReq,
                tagDataReq);
        call.enqueue(new Callback<UploadAdResultData>() {
            @Override
            public void onResponse(@NonNull Call<UploadAdResultData> call, @NonNull Response<UploadAdResultData> response) {
                UploadAdResultData responseBody = response.body();
                Log.d("sonusourav", "is instance " + (responseBody instanceof UploadAdResultData));
                Log.d("sonusourav", "getting url %s " + (new Gson().toJson(responseBody)));
                Toast.makeText(getContext(), "Successfully uploaded", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                callSolidityCode(responseBody.getAdId());
            }

            @Override
            public void onFailure(Call<UploadAdResultData> call, Throwable t) {
                Toast.makeText(getContext(), "An error has occured", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }

        });
    }

    private void callSolidityCode(String adId) {

        String contractAddress = "0x8394cDf176A4A52DA5889f7a99c4f7AD2BF59088";
        String url = "https://rinkeby.infura.io/v3/01eb8f7b5e514832af8e827c23784d23";
        Web3j web3j = Web3jFactory.build(new InfuraHttpService(url));
        BigInteger gasLimit = BigInteger.valueOf(20_000_000_000L);
        BigInteger gasPrice = BigInteger.valueOf(4300000);
        String privateKey = "";

        try {
            if (currentWallet != null) {
                String mnemonic = unpackMnemonic(currentWallet);

                privateKey = getPrivateKeyFromMnemonic(mnemonic);
                Log.d("sonusourav", "private key " + privateKey);

            }
        } catch (UserNotAuthenticatedException | KeyServiceException e) {
            e.printStackTrace();
        }

        Credentials credentials = Credentials.create("5580192c15364fc23bb59cd6e071ed04e31371156ef55e20b49c13b498ad7325");

        Vendo vendo = Vendo.load(contractAddress, web3j, credentials, gasLimit, gasPrice);

        // write to contract
        CompletableFuture<TransactionReceipt> transactionReceipt = vendo.postAd(adId, new BigInteger("0")).sendAsync();
        try {
            String result =
                    "Successful transaction. Gas used: " + transactionReceipt.get().getBlockNumber() + "" + transactionReceipt.get().getGasUsed();
            Log.d("sonusourav", result);
        } catch (Exception e) {
            Log.d("sonusourav", e.getMessage());
        }

    }

    private static final String ANDROID_KEY_STORE = "AndroidKeyStore";
    private static final String CIPHER_ALGORITHM = "AES/GCM/NoPadding";

    private synchronized String unpackMnemonic(Wallet currentWallet) throws KeyServiceException, UserNotAuthenticatedException {
        try {
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE);
            keyStore.load(null);
            String matchingAddr = findMatchingAddrInKeyStore(currentWallet.address);
            if (!keyStore.containsAlias(matchingAddr)) {
                throw new KeyServiceException("Key not found in keystore. Re-import key.");
            }

            //create a stream to the encrypted bytes
            FileInputStream encryptedHDKeyBytes = new FileInputStream(getFilePath(getActivity(), matchingAddr));
            SecretKey secretKey = (SecretKey) keyStore.getKey(matchingAddr, null);
            boolean ivExists = new File(getFilePath(getActivity(), matchingAddr + "iv")).exists();
            byte[] iv = null;

            if (ivExists)
                iv = readBytesFromFile(getFilePath(getActivity(), matchingAddr + "iv"));
            if (iv == null || iv.length == 0) {
                throw new KeyServiceException(getActivity().getString(R.string.cannot_read_encrypt_file));
            }
            Cipher outCipher = Cipher.getInstance(CIPHER_ALGORITHM);
            final GCMParameterSpec spec = new GCMParameterSpec(128, iv);
            outCipher.init(Cipher.DECRYPT_MODE, secretKey, spec);
            CipherInputStream cipherInputStream = new CipherInputStream(encryptedHDKeyBytes, outCipher);
            byte[] mnemonicBytes = readBytesFromStream(cipherInputStream);
            return new String(mnemonicBytes);
        } catch (InvalidKeyException e) {
            if (e instanceof UserNotAuthenticatedException) {
                throw new UserNotAuthenticatedException(getActivity().getString(R.string.authentication_error));
            } else {
                throw new KeyServiceException(e.getMessage());
            }
        } catch (UnrecoverableKeyException e) {
            throw new KeyServiceException(getActivity().getString(R.string.device_security_changed));
        } catch (IOException | CertificateException | KeyStoreException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
            throw new KeyServiceException(e.getMessage());
        } catch (Exception e) {
            throw new KeyServiceException(e.getMessage());
        }
    }

    private String findMatchingAddrInKeyStore(String keyAddress) {
        try {
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEY_STORE);
            keyStore.load(null);
            Enumeration<String> keys = keyStore.aliases();

            while (keys.hasMoreElements()) {
                String thisKey = keys.nextElement();
                if (keyAddress.equalsIgnoreCase(thisKey)) {
                    return thisKey;
                }
            }
        } catch (Exception e) {
            if (BuildConfig.DEBUG) e.printStackTrace();
        }

        return keyAddress;
    }

    synchronized static String getFilePath(Context context, String fileName) {
        //check for matching file
        File check = new File(context.getFilesDir(), fileName);
        if (check.exists()) {
            return check.getAbsolutePath(); //quick return
        } else {
            //find matching file, ignoring case
            File[] files = context.getFilesDir().listFiles();
            for (File checkFile : files) {
                if (checkFile.getName().equalsIgnoreCase(fileName)) {
                    return checkFile.getAbsolutePath();
                }
            }
        }

        return check.getAbsolutePath(); //Should never get here
    }

    static byte[] readBytesFromFile(String path) {
        byte[] bytes = null;
        FileInputStream fin;
        try {
            File file = new File(path);
            fin = new FileInputStream(file);
            bytes = readBytesFromStream(fin);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    static byte[] readBytesFromStream(InputStream in) {
        // this dynamically extends to take the bytes you read
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        // this is storage overwritten on each iteration with bytes
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        // we need to know how may bytes were read to write them to the byteBuffer
        int len;
        try {
            while ((len = in.read(buffer)) != -1) {
                byteBuffer.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteBuffer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // and then we can return your byte array.
        return byteBuffer.toByteArray();
    }


}
