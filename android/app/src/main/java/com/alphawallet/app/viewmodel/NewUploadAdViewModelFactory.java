package com.alphawallet.app.viewmodel;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.alphawallet.app.interact.GenericWalletInteract;
import com.alphawallet.app.repository.PreferenceRepositoryType;
import com.alphawallet.app.router.ManageWalletsRouter;
import com.alphawallet.app.router.MyAddressRouter;

public class NewUploadAdViewModelFactory implements ViewModelProvider.Factory {
    private final MyAddressRouter myAddressRouter;
    private final GenericWalletInteract genericWalletInteract;
    private final ManageWalletsRouter manageWalletsRouter;
    private final PreferenceRepositoryType preferenceRepository;

    public NewUploadAdViewModelFactory(
            GenericWalletInteract genericWalletInteract,
            MyAddressRouter myAddressRouter,
            ManageWalletsRouter manageWalletsRouter,
            PreferenceRepositoryType preferenceRepository) {
        this.genericWalletInteract = genericWalletInteract;
        this.myAddressRouter = myAddressRouter;
        this.manageWalletsRouter = manageWalletsRouter;
        this.preferenceRepository = preferenceRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new NewUploadAdViewModel(
                genericWalletInteract,
                myAddressRouter,
                manageWalletsRouter,
                preferenceRepository
        );
    }
}
