package com.alphawallet.app.ui;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Vendo extends Contract {
    public static final StringBuilder builder = new StringBuilder("{\n"
            + "\t\"functionDebugData\": {\n"
            + "\t\t\"@_44\": {\n"
            + "\t\t\t\"entryPoint\": null,\n"
            + "\t\t\t\"id\": 44,\n"
            + "\t\t\t\"parameterSlots\": 2,\n"
            + "\t\t\t\"returnSlots\": 0\n"
            + "\t\t},\n"
            + "\t\t\"@_704\": {\n"
            + "\t\t\t\"entryPoint\": null,\n"
            + "\t\t\t\"id\": 704,\n"
            + "\t\t\t\"parameterSlots\": 0,\n"
            + "\t\t\t\"returnSlots\": 0\n"
            + "\t\t},\n"
            + "\t\t\"extract_byte_array_length\": {\n"
            + "\t\t\t\"entryPoint\": 411,\n"
            + "\t\t\t\"id\": null,\n"
            + "\t\t\t\"parameterSlots\": 1,\n"
            + "\t\t\t\"returnSlots\": 1\n"
            + "\t\t},\n"
            + "\t\t\"panic_error_0x22\": {\n").append("\t\t\t\"entryPoint\": 465,\n"
            + "\t\t\t\"id\": null,\n"
            + "\t\t\t\"parameterSlots\": 0,\n"
            + "\t\t\t\"returnSlots\": 0\n"
            + "\t\t}\n"
            + "\t},\n"
            + "\t\"generatedSources\": [\n"
            + "\t\t{\n"
            + "\t\t\t\"ast\": {\n"
            + "\t\t\t\t\"nodeType\": \"YulBlock\",\n"
            + "\t\t\t\t\"src\": \"0:516:5\",\n"
            + "\t\t\t\t\"statements\": [\n"
            + "\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\"body\": {\n"
            + "\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\n"
            + "\t\t\t\t\t\t\t\"src\": \"58:269:5\",\n"
            + "\t\t\t\t\t\t\t\"statements\": [\n"
            + "\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulAssignment\",\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"68:22:5\",\n"
            + "\t\t\t\t\t\t\t\t\t\"value\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n").append(
            "\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"data\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"129:4:5\"\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t},\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t{\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"135:1:5\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"1\"\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t}\n"
                    + "\t\t\t\t\t\t\t\t\t\t],\n"
                    + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"and\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"125:3:5\"\n"
                    + "\t\t\t\t\t\t\t\t\t\t},\n"
                    + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\"src\": \"125:12:5\"\n"
                    + "\t\t\t\t\t\t\t\t\t},\n"
                    + "\t\t\t\t\t\t\t\t\t\"variables\": [\n"
                    + "\t\t\t\t\t\t\t\t\t\t{\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"outOfPlaceEncoding\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"103:18:5\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\"\n"
                    + "\t\t\t\t\t\t\t\t\t\t}\n"
                    + "\t\t\t\t\t\t\t\t\t]\n"
                    + "\t\t\t\t\t\t\t\t},\n"
                    + "\t\t\t\t\t\t\t\t{\n"
                    + "\t\t\t\t\t\t\t\t\t\"body\": {\n"
                    + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\"src\": \"176:51:5\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\"statements\": [\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t{\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulAssignment\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"190:27:5\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": {\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"length\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"204:6:5\"\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t},\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
    ).append(
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"212:4:5\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0x7f\"\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t],\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"and\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"200:3:5\"\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"200:17:5\"\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t},\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"variableNames\": [\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"length\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"190:6:5\"\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t]\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t}\n"
                    + "\t\t\t\t\t\t\t\t\t\t]\n"
                    + "\t\t\t\t\t\t\t\t\t},\n"
                    + "\t\t\t\t\t\t\t\t\t\"condition\": {\n"
                    + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t{\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"outOfPlaceEncoding\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"156:18:5\"\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t}\n"
    ).append("\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"iszero\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"149:6:5\"\n"
            + "\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"149:26:5\"\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIf\",\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"146:81:5\"\n"
            + "\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\"body\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"279:42:5\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"statements\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"expression\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"arguments\": [],\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"panic_error_0x22\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"293:16:5\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"293:18:5\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulExpressionStatement\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"293:18:5\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"condition\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"outOfPlaceEncoding\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"243:18:5\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n").append(
            "\t\t\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"length\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"266:6:5\"\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t},\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t{\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"274:2:5\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"32\"\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t}\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t],\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"name\": \"lt\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"263:2:5\"\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t},\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"263:14:5\"\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t}\n"
                    + "\t\t\t\t\t\t\t\t\t\t],\n"
                    + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"eq\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"240:2:5\"\n"
                    + "\t\t\t\t\t\t\t\t\t\t},\n"
                    + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\"src\": \"240:38:5\"\n"
                    + "\t\t\t\t\t\t\t\t\t},\n"
                    + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIf\",\n"
                    + "\t\t\t\t\t\t\t\t\t\"src\": \"237:84:5\"\n"
                    + "\t\t\t\t\t\t\t\t}\n"
                    + "\t\t\t\t\t\t\t]\n"
                    + "\t\t\t\t\t\t},\n"
                    + "\t\t\t\t\t\t\"name\": \"extract_byte_array_length\",\n"
                    + "\t\t\t\t\t\t\"nodeType\": \"YulFunctionDefinition\",\n"
                    + "\t\t\t\t\t\t\"parameters\": [\n"
                    + "\t\t\t\t\t\t\t{\n"
                    + "\t\t\t\t\t\t\t\t\"name\": \"data\",\n"
                    + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
                    + "\t\t\t\t\t\t\t\t\"src\": \"42:4:5\",\n"
                    + "\t\t\t\t\t\t\t\t\"type\": \"\"\n"
                    + "\t\t\t\t\t\t\t}\n"
                    + "\t\t\t\t\t\t],\n"
                    + "\t\t\t\t\t\t\"returnVariables\": [\n"
                    + "\t\t\t\t\t\t\t{\n"
                    + "\t\t\t\t\t\t\t\t\"name\": \"length\",\n"
                    + "\t\t\t\t\t\t\t\t\"nodeType\": \"YulTypedName\",\n"
                    + "\t\t\t\t\t\t\t\t\"src\": \"51:6:5\",\n"
                    + "\t\t\t\t\t\t\t\t\"type\": \"\"\n"
                    + "\t\t\t\t\t\t\t}\n"
                    + "\t\t\t\t\t\t],\n"
                    + "\t\t\t\t\t\t\"src\": \"7:320:5\"\n"
                    + "\t\t\t\t\t},\n"
                    + "\t\t\t\t\t{\n"
                    + "\t\t\t\t\t\t\"body\": {\n"
                    + "\t\t\t\t\t\t\t\"nodeType\": \"YulBlock\",\n"
                    + "\t\t\t\t\t\t\t\"src\": \"361:152:5\",\n"
                    + "\t\t\t\t\t\t\t\"statements\": [\n"
                    + "\t\t\t\t\t\t\t\t{\n"
                    + "\t\t\t\t\t\t\t\t\t\"expression\": {\n"
                    + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t{\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"378:1:5\",\n"
                    + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
    ).append("\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"381:77:5\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"35408467139433450592217433187231851964531694900788300625387963629091585785856\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"mstore\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"371:6:5\"\n"
            + "\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"371:88:5\"\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulExpressionStatement\",\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"371:88:5\"\n"
            + "\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\"expression\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"475:1:5\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"4\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"478:4:5\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0x22\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"mstore\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"468:6:5\"\n"
            + "\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"468:15:5\"\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulExpressionStatement\",\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"468:15:5\"\n"
            + "\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\"expression\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\"arguments\": [\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"499:1:5\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\t{\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"kind\": \"number\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulLiteral\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"src\": \"502:4:5\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"type\": \"\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\t\"value\": \"0x24\"\n"
            + "\t\t\t\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t\t\t\t],\n"
            + "\t\t\t\t\t\t\t\t\t\t\"functionName\": {\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"name\": \"revert\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulIdentifier\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\t\"src\": \"492:6:5\"\n"
            + "\t\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulFunctionCall\",\n"
            + "\t\t\t\t\t\t\t\t\t\t\"src\": \"492:15:5\"\n"
            + "\t\t\t\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\t\t\t\"nodeType\": \"YulExpressionStatement\",\n"
            + "\t\t\t\t\t\t\t\t\t\"src\": \"492:15:5\"\n"
            + "\t\t\t\t\t\t\t\t}\n"
            + "\t\t\t\t\t\t\t]\n"
            + "\t\t\t\t\t\t},\n"
            + "\t\t\t\t\t\t\"name\": \"panic_error_0x22\",\n"
            + "\t\t\t\t\t\t\"nodeType\": \"YulFunctionDefinition\",\n"
            + "\t\t\t\t\t\t\"src\": \"333:180:5\"\n"
            + "\t\t\t\t\t}\n"
            + "\t\t\t\t]\n"
            + "\t\t\t},\n"
            + "\t\t\t\"contents\": \"{\\n\\n    function extract_byte_array_length(data) -> length {\\n        length := div(data, 2)\\n        let outOfPlaceEncoding := and(data, 1)\\n        if iszero(outOfPlaceEncoding) {\\n            length := and(length, 0x7f)\\n        }\\n\\n        if eq(outOfPlaceEncoding, lt(length, 32)) {\\n            panic_error_0x22()\\n        }\\n    }\\n\\n    function panic_error_0x22() {\\n        mstore(0, 35408467139433450592217433187231851964531694900788300625387963629091585785856)\\n        mstore(4, 0x22)\\n        revert(0, 0x24)\\n    }\\n\\n}\\n\",\n"
            + "\t\t\t\"id\": 5,\n"
            + "\t\t\t\"language\": \"Yul\",\n"
            + "\t\t\t\"name\": \"#utility.yul\"\n"
            + "\t\t}\n"
            + "\t],\n"
            + "\t\"linkReferences\": {},\n"
            + "\t\"object\": \"60806040526040518060400160405280600581526020017f76656e646f0000000000000000000000000000000000000000000000000000008152506040518060400160405280600381526020017f76656e0000000000000000000000000000000000000000000000000000000000815250816003908051906020019062000088929190620000eb565b508060049080519060200190620000a1929190620000eb565b50505033600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555062000200565b828054620000f9906200019b565b90600052602060002090601f0160209004810192826200011d576000855562000169565b82601f106200013857805160ff191683800117855562000169565b8280016001018555821562000169579182015b82811115620001685782518255916020019190600101906200014b565b5b5090506200017891906200017c565b5090565b5b80821115620001975760008160009055506001016200017d565b5090565b60006002820490506001821680620001b457607f821691505b60208210811415620001cb57620001ca620001d1565b5b50919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b6120e480620002106000396000f3fe6080604052600436106100fe5760003560e01c8063634d3b3a11610095578063a457c2d711610064578063a457c2d714610372578063a9059cbb146103af578063bfc06629146103ec578063db006a7514610408578063dd62ed3e14610424576100fe565b8063634d3b3a146102a4578063655fc033146102e157806370a082311461030a57806395d89b4114610347576100fe565b8063313ce567116100d1578063313ce567146101d357806339509351146101fe5780635609fa281461023b5780635778d26114610266576100fe565b806306fdde0314610103578063095ea7b31461012e57806318160ddd1461016b57806323b872dd14610196575b600080fd5b34801561010f57600080fd5b50610118610461565b6040516101259190611936565b60405180910390f35b34801561013a57600080fd5b5061015560048036038101906101509190611507565b6104f3565b60405161016291906118bb565b60405180910390f35b34801561017757600080fd5b50610180610511565b60405161018d9190611a58565b60405180910390f35b3480156101a257600080fd5b506101bd60048036038101906101b891906114b4565b61051b565b6040516101ca91906118bb565b60405180910390f35b3480156101df57600080fd5b506101e8610613565b6040516101f59190611a73565b60405180910390f35b34801561020a57600080fd5b5061022560048036038101906102209190611507565b61061c565b60405161023291906118bb565b60405180910390f35b34801561024757600080fd5b506102506106c8565b60405161025d9190611877565b60405180910390f35b34801561027257600080fd5b5061028d60048036038101906102889190611574565b6106ee565b60405161029b929190611892565b60405180910390f35b3480156102b057600080fd5b506102cb60048036038101906102c69190611547565b610748565b6040516102d891906118bb565b60405180910390f35b3480156102ed57600080fd5b50610308600480360381019061030391906115bd565b610768565b005b34801561031657600080fd5b50610331600480360381019061032c9190611447565b610978565b60405161033e9190611a58565b60405180910390f35b34801561035357600080fd5b5061035c6109c0565b6040516103699190611936565b60405180910390f35b34801561037e57600080fd5b5061039960048036038101906103949190611507565b610a52565b6040516103a691906118bb565b60405180910390f35b3480156103bb57600080fd5b506103d660048036038101906103d19190611507565b610b3d565b6040516103e391906118bb565b60405180910390f35b61040660048036038101906104019190611574565b610b5b565b005b610422600480360381019061041d9190611666565b610c72565b005b34801561043057600080fd5b5061044b60048036038101906104469190611474565b610d3e565b6040516104589190611a58565b60405180910390f35b60606003805461047090611c8d565b80601f016020809104026020016040519081016040528092919081815260200182805461049c90611c8d565b80156104e95780601f106104be576101008083540402835291602001916104e9565b820191906000526020600020905b8154815290600101906020018083116104cc57829003601f168201915b5050505050905090565b6000610507610500610dc5565b8484610dcd565b6001905092915050565b6000600254905090565b6000610528848484610f98565b6000600160008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000610573610dc5565b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050828110156105f3576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016105ea906119b8565b60405180910390fd5b610607856105ff610dc5565b858403610dcd565b60019150509392505050565b60006012905090565b60006106be610629610dc5565b848460016000610637610dc5565b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020546106b99190611b0b565b610dcd565b6001905092915050565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6006818051602081018201805184825260208301602085012081835280955050505050506000915090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060010154905082565b60076020528060005260406000206000915054906101000a900460ff1681565b600115156007600087815260200190815260200160002060009054906101000a900460ff16151514156107d257846040517faedcf5c50000000000000000000000000000000000000000000000000000000081526004016107c991906118d6565b60405180910390fd5b600185858585604051600081526020016040526040516107f594939291906118f1565b6020604051602081039080840390855afa158015610817573d6000803e3d6000fd5b5050506020604051035173ffffffffffffffffffffffffffffffffffffffff16600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161461087e5761087d611cf0565b5b60016007600087815260200190815260200160002060006101000a81548160ff02191690831515021790555060006006876040516108bc9190611860565b908152602001604051809103902060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690506108fc81836007610f98565b61090881336001610f98565b61093681600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166002610f98565b60016006886040516109489190611860565b908152602001604051809103902060010160008282546109689190611b0b565b9250508190555050505050505050565b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b6060600480546109cf90611c8d565b80601f01602080910402602001604051908101604052809291908181526020018280546109fb90611c8d565b8015610a485780601f10610a1d57610100808354040283529160200191610a48565b820191906000526020600020905b815481529060010190602001808311610a2b57829003601f168201915b5050505050905090565b60008060016000610a61610dc5565b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905082811015610b1e576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610b1590611a18565b60405180910390fd5b610b32610b29610dc5565b85858403610dcd565b600191505092915050565b6000610b51610b4a610dc5565b8484610f98565b6001905092915050565b6000670de0b6b3a7640000610d0534610b749190611b92565b610b7e9190611b61565b90506000811415610bc657346040517f97c5f70e000000000000000000000000000000000000000000000000000000008152600401610bbd9190611a58565b60405180910390fd5b610bd03382611219565b60405180604001604052803373ffffffffffffffffffffffffffffffffffffffff1681526020016000815250600683604051610c0c9190611860565b908152602001604051809103902060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550602082015181600101559050505050565b610c9e600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1682610b3d565b506000610d05670de0b6b3a764000083610cb89190611b92565b610cc29190611b61565b90503373ffffffffffffffffffffffffffffffffffffffff166108fc829081150290604051600060405180830381858888f19350505050610d3a57336040517f810fd2b2000000000000000000000000000000000000000000000000000000008152600401610d319190611877565b60405180910390fd5b5050565b6000600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905092915050565b600033905090565b600073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff161415610e3d576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610e34906119f8565b60405180910390fd5b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415610ead576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610ea490611978565b60405180910390fd5b80600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508173ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92583604051610f8b9190611a58565b60405180910390a3505050565b600073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff161415611008576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610fff906119d8565b60405180910390fd5b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415611078576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161106f90611958565b60405180910390fd5b611083838383611379565b60008060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905081811015611109576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161110090611998565b60405180910390fd5b8181036000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550816000808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600082825461119c9190611b0b565b925050819055508273ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef846040516112009190611a58565b60405180910390a361121384848461137e565b50505050565b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415611289576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161128090611a38565b60405180910390fd5b61129560008383611379565b80600260008282546112a79190611b0b565b92505081905550806000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282546112fc9190611b0b565b925050819055508173ffffffffffffffffffffffffffffffffffffffff16600073ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef836040516113619190611a58565b60405180910390a36113756000838361137e565b5050565b505050565b505050565b600061139661139184611ab3565b611a8e565b9050828152602081018484840111156113b2576113b1611de0565b5b6113bd848285611c4b565b509392505050565b6000813590506113d481612052565b92915050565b6000813590506113e981612069565b92915050565b600082601f83011261140457611403611ddb565b5b8135611414848260208601611383565b91505092915050565b60008135905061142c81612080565b92915050565b60008135905061144181612097565b92915050565b60006020828403121561145d5761145c611dea565b5b600061146b848285016113c5565b91505092915050565b6000806040838503121561148b5761148a611dea565b5b6000611499858286016113c5565b92505060206114aa858286016113c5565b9150509250929050565b6000806000606084860312156114cd576114cc611dea565b5b60006114db868287016113c5565b93505060206114ec868287016113c5565b92505060406114fd8682870161141d565b9150509250925092565b6000806040838503121561151e5761151d611dea565b5b600061152c858286016113c5565b925050602061153d8582860161141d565b9150509250929050565b60006020828403121561155d5761155c611dea565b5b600061156b848285016113da565b91505092915050565b60006020828403121561158a57611589611dea565b5b600082013567ffffffffffffffff8111156115a8576115a7611de5565b5b6115b4848285016113ef565b91505092915050565b60008060008060008060c087890312156115da576115d9611dea565b5b600087013567ffffffffffffffff8111156115f8576115f7611de5565b5b61160489828a016113ef565b965050602061161589828a016113da565b955050604061162689828a01611432565b945050606061163789828a016113da565b935050608061164889828a016113da565b92505060a061165989828a016113c5565b9150509295509295509295565b60006020828403121561167c5761167b611dea565b5b600061168a8482850161141d565b91505092915050565b61169c81611bec565b82525050565b6116ab81611bfe565b82525050565b6116ba81611c0a565b82525050565b60006116cb82611ae4565b6116d58185611aef565b93506116e5818560208601611c5a565b6116ee81611def565b840191505092915050565b600061170482611ae4565b61170e8185611b00565b935061171e818560208601611c5a565b80840191505092915050565b6000611737602383611aef565b915061174282611e00565b604082019050919050565b600061175a602283611aef565b915061176582611e4f565b604082019050919050565b600061177d602683611aef565b915061178882611e9e565b604082019050919050565b60006117a0602883611aef565b91506117ab82611eed565b604082019050919050565b60006117c3602583611aef565b91506117ce82611f3c565b604082019050919050565b60006117e6602483611aef565b91506117f182611f8b565b604082019050919050565b6000611809602583611aef565b915061181482611fda565b604082019050919050565b600061182c601f83611aef565b915061183782612029565b602082019050919050565b61184b81611c34565b82525050565b61185a81611c3e565b82525050565b600061186c82846116f9565b915081905092915050565b600060208201905061188c6000830184611693565b92915050565b60006040820190506118a76000830185611693565b6118b46020830184611842565b9392505050565b60006020820190506118d060008301846116a2565b92915050565b60006020820190506118eb60008301846116b1565b92915050565b600060808201905061190660008301876116b1565b6119136020830186611851565b61192060408301856116b1565b61192d60608301846116b1565b95945050505050565b6000602082019050818103600083015261195081846116c0565b905092915050565b600060208201905081810360008301526119718161172a565b9050919050565b600060208201905081810360008301526119918161174d565b9050919050565b600060208201905081810360008301526119b181611770565b9050919050565b600060208201905081810360008301526119d181611793565b9050919050565b600060208201905081810360008301526119f1816117b6565b9050919050565b60006020820190508181036000830152611a11816117d9565b9050919050565b60006020820190508181036000830152611a31816117fc565b9050919050565b60006020820190508181036000830152611a518161181f565b9050919050565b6000602082019050611a6d6000830184611842565b92915050565b6000602082019050611a886000830184611851565b92915050565b6000611a98611aa9565b9050611aa48282611cbf565b919050565b6000604051905090565b600067ffffffffffffffff821115611ace57611acd611dac565b5b611ad782611def565b9050602081019050919050565b600081519050919050565b600082825260208201905092915050565b600081905092915050565b6000611b1682611c34565b9150611b2183611c34565b9250827fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff03821115611b5657611b55611d1f565b5b828201905092915050565b6000611b6c82611c34565b9150611b7783611c34565b925082611b8757611b86611d4e565b5b828204905092915050565b6000611b9d82611c34565b9150611ba883611c34565b9250817fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff0483118215151615611be157611be0611d1f565b5b828202905092915050565b6000611bf782611c14565b9050919050565b60008115159050919050565b6000819050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b600060ff82169050919050565b82818337600083830152505050565b60005b83811015611c78578082015181840152602081019050611c5d565b83811115611c87576000848401525b50505050565b60006002820490506001821680611ca557607f821691505b60208210811415611cb957611cb8611d7d565b5b50919050565b611cc882611def565b810181811067ffffffffffffffff82111715611ce757611ce6611dac565b5b80604052505050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052600160045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b600080fd5b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f45524332303a207472616e7366657220746f20746865207a65726f206164647260008201527f6573730000000000000000000000000000000000000000000000000000000000602082015250565b7f45524332303a20617070726f766520746f20746865207a65726f20616464726560008201527f7373000000000000000000000000000000000000000000000000000000000000602082015250565b7f45524332303a207472616e7366657220616d6f756e742065786365656473206260008201527f616c616e63650000000000000000000000000000000000000000000000000000602082015250565b7f45524332303a207472616e7366657220616d6f756e742065786365656473206160008201527f6c6c6f77616e6365000000000000000000000000000000000000000000000000602082015250565b7f45524332303a207472616e736665722066726f6d20746865207a65726f20616460008201527f6472657373000000000000000000000000000000000000000000000000000000602082015250565b7f45524332303a20617070726f76652066726f6d20746865207a65726f2061646460008201527f7265737300000000000000000000000000000000000000000000000000000000602082015250565b7f45524332303a2064656372656173656420616c6c6f77616e63652062656c6f7760008201527f207a65726f000000000000000000000000000000000000000000000000000000602082015250565b7f45524332303a206d696e7420746f20746865207a65726f206164647265737300600082015250565b61205b81611bec565b811461206657600080fd5b50565b61207281611c0a565b811461207d57600080fd5b50565b61208981611c34565b811461209457600080fd5b50565b6120a081611c3e565b81146120ab57600080fd5b5056fea2646970667358221220e845d02e29651a259ee8e5ef0a0ef3459c0f32504c39bab020cb737a987a9b4464736f6c63430008070033\",\n"
            + "\t\"opcodes\": \"PUSH1 0x80 PUSH1 0x40 MSTORE PUSH1 0x40 MLOAD DUP1 PUSH1 0x40 ADD PUSH1 0x40 MSTORE DUP1 PUSH1 0x5 DUP2 MSTORE PUSH1 0x20 ADD PUSH32 0x76656E646F000000000000000000000000000000000000000000000000000000 DUP2 MSTORE POP PUSH1 0x40 MLOAD DUP1 PUSH1 0x40 ADD PUSH1 0x40 MSTORE DUP1 PUSH1 0x3 DUP2 MSTORE PUSH1 0x20 ADD PUSH32 0x76656E0000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE POP DUP2 PUSH1 0x3 SWAP1 DUP1 MLOAD SWAP1 PUSH1 0x20 ADD SWAP1 PUSH3 0x88 SWAP3 SWAP2 SWAP1 PUSH3 0xEB JUMP JUMPDEST POP DUP1 PUSH1 0x4 SWAP1 DUP1 MLOAD SWAP1 PUSH1 0x20 ADD SWAP1 PUSH3 0xA1 SWAP3 SWAP2 SWAP1 PUSH3 0xEB JUMP JUMPDEST POP POP POP CALLER PUSH1 0x5 PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF MUL NOT AND SWAP1 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND MUL OR SWAP1 SSTORE POP PUSH3 0x200 JUMP JUMPDEST DUP3 DUP1 SLOAD PUSH3 0xF9 SWAP1 PUSH3 0x19B JUMP JUMPDEST SWAP1 PUSH1 0x0 MSTORE PUSH1 0x20 PUSH1 0x0 KECCAK256 SWAP1 PUSH1 0x1F ADD PUSH1 0x20 SWAP1 DIV DUP2 ADD SWAP3 DUP3 PUSH3 0x11D JUMPI PUSH1 0x0 DUP6 SSTORE PUSH3 0x169 JUMP JUMPDEST DUP3 PUSH1 0x1F LT PUSH3 0x138 JUMPI DUP1 MLOAD PUSH1 0xFF NOT AND DUP4 DUP1 ADD OR DUP6 SSTORE PUSH3 0x169 JUMP JUMPDEST DUP3 DUP1 ADD PUSH1 0x1 ADD DUP6 SSTORE DUP3 ISZERO PUSH3 0x169 JUMPI SWAP2 DUP3 ADD JUMPDEST DUP3 DUP2 GT ISZERO PUSH3 0x168 JUMPI DUP3 MLOAD DUP3 SSTORE SWAP2 PUSH1 0x20 ADD SWAP2 SWAP1 PUSH1 0x1 ADD SWAP1 PUSH3 0x14B JUMP JUMPDEST JUMPDEST POP SWAP1 POP PUSH3 0x178 SWAP2 SWAP1 PUSH3 0x17C JUMP JUMPDEST POP SWAP1 JUMP JUMPDEST JUMPDEST DUP1 DUP3 GT ISZERO PUSH3 0x197 JUMPI PUSH1 0x0 DUP2 PUSH1 0x0 SWAP1 SSTORE POP PUSH1 0x1 ADD PUSH3 0x17D JUMP JUMPDEST POP SWAP1 JUMP JUMPDEST PUSH1 0x0 PUSH1 0x2 DUP3 DIV SWAP1 POP PUSH1 0x1 DUP3 AND DUP1 PUSH3 0x1B4 JUMPI PUSH1 0x7F DUP3 AND SWAP2 POP JUMPDEST PUSH1 0x20 DUP3 LT DUP2 EQ ISZERO PUSH3 0x1CB JUMPI PUSH3 0x1CA PUSH3 0x1D1 JUMP JUMPDEST JUMPDEST POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x22 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH2 0x20E4 DUP1 PUSH3 0x210 PUSH1 0x0 CODECOPY PUSH1 0x0 RETURN INVALID PUSH1 0x80 PUSH1 0x40 MSTORE PUSH1 0x4 CALLDATASIZE LT PUSH2 0xFE JUMPI PUSH1 0x0 CALLDATALOAD PUSH1 0xE0 SHR DUP1 PUSH4 0x634D3B3A GT PUSH2 0x95 JUMPI DUP1 PUSH4 0xA457C2D7 GT PUSH2 0x64 JUMPI DUP1 PUSH4 0xA457C2D7 EQ PUSH2 0x372 JUMPI DUP1 PUSH4 0xA9059CBB EQ PUSH2 0x3AF JUMPI DUP1 PUSH4 0xBFC06629 EQ PUSH2 0x3EC JUMPI DUP1 PUSH4 0xDB006A75 EQ PUSH2 0x408 JUMPI DUP1 PUSH4 0xDD62ED3E EQ PUSH2 0x424 JUMPI PUSH2 0xFE JUMP JUMPDEST DUP1 PUSH4 0x634D3B3A EQ PUSH2 0x2A4 JUMPI DUP1 PUSH4 0x655FC033 EQ PUSH2 0x2E1 JUMPI DUP1 PUSH4 0x70A08231 EQ PUSH2 0x30A JUMPI DUP1 PUSH4 0x95D89B41 EQ PUSH2 0x347 JUMPI PUSH2 0xFE JUMP JUMPDEST DUP1 PUSH4 0x313CE567 GT PUSH2 0xD1 JUMPI DUP1 PUSH4 0x313CE567 EQ PUSH2 0x1D3 JUMPI DUP1 PUSH4 0x39509351 EQ PUSH2 0x1FE JUMPI DUP1 PUSH4 0x5609FA28 EQ PUSH2 0x23B JUMPI DUP1 PUSH4 0x5778D261 EQ PUSH2 0x266 JUMPI PUSH2 0xFE JUMP JUMPDEST DUP1 PUSH4 0x6FDDE03 EQ PUSH2 0x103 JUMPI DUP1 PUSH4 0x95EA7B3 EQ PUSH2 0x12E JUMPI DUP1 PUSH4 0x18160DDD EQ PUSH2 0x16B JUMPI DUP1 PUSH4 0x23B872DD EQ PUSH2 0x196 JUMPI JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x10F JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x118 PUSH2 0x461 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x125 SWAP2 SWAP1 PUSH2 0x1936 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x13A JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x155 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x150 SWAP2 SWAP1 PUSH2 0x1507 JUMP JUMPDEST PUSH2 0x4F3 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x162 SWAP2 SWAP1 PUSH2 0x18BB JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x177 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x180 PUSH2 0x511 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x18D SWAP2 SWAP1 PUSH2 0x1A58 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x1A2 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x1BD PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x1B8 SWAP2 SWAP1 PUSH2 0x14B4 JUMP JUMPDEST PUSH2 0x51B JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x1CA SWAP2 SWAP1 PUSH2 0x18BB JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x1DF JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x1E8 PUSH2 0x613 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x1F5 SWAP2 SWAP1 PUSH2 0x1A73 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x20A JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x225 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x220 SWAP2 SWAP1 PUSH2 0x1507 JUMP JUMPDEST PUSH2 0x61C JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x232 SWAP2 SWAP1 PUSH2 0x18BB JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x247 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x250 PUSH2 0x6C8 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x25D SWAP2 SWAP1 PUSH2 0x1877 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x272 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x28D PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x288 SWAP2 SWAP1 PUSH2 0x1574 JUMP JUMPDEST PUSH2 0x6EE JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x29B SWAP3 SWAP2 SWAP1 PUSH2 0x1892 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x2B0 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x2CB PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x2C6 SWAP2 SWAP1 PUSH2 0x1547 JUMP JUMPDEST PUSH2 0x748 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x2D8 SWAP2 SWAP1 PUSH2 0x18BB JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x2ED JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x308 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x303 SWAP2 SWAP1 PUSH2 0x15BD JUMP JUMPDEST PUSH2 0x768 JUMP JUMPDEST STOP JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x316 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x331 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x32C SWAP2 SWAP1 PUSH2 0x1447 JUMP JUMPDEST PUSH2 0x978 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x33E SWAP2 SWAP1 PUSH2 0x1A58 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x353 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x35C PUSH2 0x9C0 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x369 SWAP2 SWAP1 PUSH2 0x1936 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x37E JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x399 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x394 SWAP2 SWAP1 PUSH2 0x1507 JUMP JUMPDEST PUSH2 0xA52 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x3A6 SWAP2 SWAP1 PUSH2 0x18BB JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x3BB JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x3D6 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x3D1 SWAP2 SWAP1 PUSH2 0x1507 JUMP JUMPDEST PUSH2 0xB3D JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x3E3 SWAP2 SWAP1 PUSH2 0x18BB JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x406 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x401 SWAP2 SWAP1 PUSH2 0x1574 JUMP JUMPDEST PUSH2 0xB5B JUMP JUMPDEST STOP JUMPDEST PUSH2 0x422 PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x41D SWAP2 SWAP1 PUSH2 0x1666 JUMP JUMPDEST PUSH2 0xC72 JUMP JUMPDEST STOP JUMPDEST CALLVALUE DUP1 ISZERO PUSH2 0x430 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH2 0x44B PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x446 SWAP2 SWAP1 PUSH2 0x1474 JUMP JUMPDEST PUSH2 0xD3E JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x458 SWAP2 SWAP1 PUSH2 0x1A58 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH1 0x60 PUSH1 0x3 DUP1 SLOAD PUSH2 0x470 SWAP1 PUSH2 0x1C8D JUMP JUMPDEST DUP1 PUSH1 0x1F ADD PUSH1 0x20 DUP1 SWAP2 DIV MUL PUSH1 0x20 ADD PUSH1 0x40 MLOAD SWAP1 DUP2 ADD PUSH1 0x40 MSTORE DUP1 SWAP3 SWAP2 SWAP1 DUP2 DUP2 MSTORE PUSH1 0x20 ADD DUP3 DUP1 SLOAD PUSH2 0x49C SWAP1 PUSH2 0x1C8D JUMP JUMPDEST DUP1 ISZERO PUSH2 0x4E9 JUMPI DUP1 PUSH1 0x1F LT PUSH2 0x4BE JUMPI PUSH2 0x100 DUP1 DUP4 SLOAD DIV MUL DUP4 MSTORE SWAP2 PUSH1 0x20 ADD SWAP2 PUSH2 0x4E9 JUMP JUMPDEST DUP3 ADD SWAP2 SWAP1 PUSH1 0x0 MSTORE PUSH1 0x20 PUSH1 0x0 KECCAK256 SWAP1 JUMPDEST DUP2 SLOAD DUP2 MSTORE SWAP1 PUSH1 0x1 ADD SWAP1 PUSH1 0x20 ADD DUP1 DUP4 GT PUSH2 0x4CC JUMPI DUP3 SWAP1 SUB PUSH1 0x1F AND DUP3 ADD SWAP2 JUMPDEST POP POP POP POP POP SWAP1 POP SWAP1 JUMP JUMPDEST PUSH1 0x0 PUSH2 0x507 PUSH2 0x500 PUSH2 0xDC5 JUMP JUMPDEST DUP5 DUP5 PUSH2 0xDCD JUMP JUMPDEST PUSH1 0x1 SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x2 SLOAD SWAP1 POP SWAP1 JUMP JUMPDEST PUSH1 0x0 PUSH2 0x528 DUP5 DUP5 DUP5 PUSH2 0xF98 JUMP JUMPDEST PUSH1 0x0 PUSH1 0x1 PUSH1 0x0 DUP7 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 PUSH2 0x573 PUSH2 0xDC5 JUMP JUMPDEST PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SLOAD SWAP1 POP DUP3 DUP2 LT ISZERO PUSH2 0x5F3 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x5EA SWAP1 PUSH2 0x19B8 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH2 0x607 DUP6 PUSH2 0x5FF PUSH2 0xDC5 JUMP JUMPDEST DUP6 DUP5 SUB PUSH2 0xDCD JUMP JUMPDEST PUSH1 0x1 SWAP2 POP POP SWAP4 SWAP3 POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x12 SWAP1 POP SWAP1 JUMP JUMPDEST PUSH1 0x0 PUSH2 0x6BE PUSH2 0x629 PUSH2 0xDC5 JUMP JUMPDEST DUP5 DUP5 PUSH1 0x1 PUSH1 0x0 PUSH2 0x637 PUSH2 0xDC5 JUMP JUMPDEST PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 DUP9 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SLOAD PUSH2 0x6B9 SWAP2 SWAP1 PUSH2 0x1B0B JUMP JUMPDEST PUSH2 0xDCD JUMP JUMPDEST PUSH1 0x1 SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x5 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 JUMP JUMPDEST PUSH1 0x6 DUP2 DUP1 MLOAD PUSH1 0x20 DUP2 ADD DUP3 ADD DUP1 MLOAD DUP5 DUP3 MSTORE PUSH1 0x20 DUP4 ADD PUSH1 0x20 DUP6 ADD KECCAK256 DUP2 DUP4 MSTORE DUP1 SWAP6 POP POP POP POP POP POP PUSH1 0x0 SWAP2 POP SWAP1 POP DUP1 PUSH1 0x0 ADD PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND SWAP1 DUP1 PUSH1 0x1 ADD SLOAD SWAP1 POP DUP3 JUMP JUMPDEST PUSH1 0x7 PUSH1 0x20 MSTORE DUP1 PUSH1 0x0 MSTORE PUSH1 0x40 PUSH1 0x0 KECCAK256 PUSH1 0x0 SWAP2 POP SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND DUP2 JUMP JUMPDEST PUSH1 0x1 ISZERO ISZERO PUSH1 0x7 PUSH1 0x0 DUP8 DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND ISZERO ISZERO EQ ISZERO PUSH2 0x7D2 JUMPI DUP5 PUSH1 0x40 MLOAD PUSH32 0xAEDCF5C500000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x7C9 SWAP2 SWAP1 PUSH2 0x18D6 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x1 DUP6 DUP6 DUP6 DUP6 PUSH1 0x40 MLOAD PUSH1 0x0 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x40 MSTORE PUSH1 0x40 MLOAD PUSH2 0x7F5 SWAP5 SWAP4 SWAP3 SWAP2 SWAP1 PUSH2 0x18F1 JUMP JUMPDEST PUSH1 0x20 PUSH1 0x40 MLOAD PUSH1 0x20 DUP2 SUB SWAP1 DUP1 DUP5 SUB SWAP1 DUP6 GAS STATICCALL ISZERO DUP1 ISZERO PUSH2 0x817 JUMPI RETURNDATASIZE PUSH1 0x0 DUP1 RETURNDATACOPY RETURNDATASIZE PUSH1 0x0 REVERT JUMPDEST POP POP POP PUSH1 0x20 PUSH1 0x40 MLOAD SUB MLOAD PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH1 0x5 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND EQ PUSH2 0x87E JUMPI PUSH2 0x87D PUSH2 0x1CF0 JUMP JUMPDEST JUMPDEST PUSH1 0x1 PUSH1 0x7 PUSH1 0x0 DUP8 DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH1 0xFF MUL NOT AND SWAP1 DUP4 ISZERO ISZERO MUL OR SWAP1 SSTORE POP PUSH1 0x0 PUSH1 0x6 DUP8 PUSH1 0x40 MLOAD PUSH2 0x8BC SWAP2 SWAP1 PUSH2 0x1860 JUMP JUMPDEST SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 KECCAK256 PUSH1 0x0 ADD PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND SWAP1 POP PUSH2 0x8FC DUP2 DUP4 PUSH1 0x7 PUSH2 0xF98 JUMP JUMPDEST PUSH2 0x908 DUP2 CALLER PUSH1 0x1 PUSH2 0xF98 JUMP JUMPDEST PUSH2 0x936 DUP2 PUSH1 0x5 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH1 0x2 PUSH2 0xF98 JUMP JUMPDEST PUSH1 0x1 PUSH1 0x6 DUP9 PUSH1 0x40 MLOAD PUSH2 0x948 SWAP2 SWAP1 PUSH2 0x1860 JUMP JUMPDEST SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 KECCAK256 PUSH1 0x1 ADD PUSH1 0x0 DUP3 DUP3 SLOAD PUSH2 0x968 SWAP2 SWAP1 PUSH2 0x1B0B JUMP JUMPDEST SWAP3 POP POP DUP2 SWAP1 SSTORE POP POP POP POP POP POP POP POP JUMP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x0 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SLOAD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x60 PUSH1 0x4 DUP1 SLOAD PUSH2 0x9CF SWAP1 PUSH2 0x1C8D JUMP JUMPDEST DUP1 PUSH1 0x1F ADD PUSH1 0x20 DUP1 SWAP2 DIV MUL PUSH1 0x20 ADD PUSH1 0x40 MLOAD SWAP1 DUP2 ADD PUSH1 0x40 MSTORE DUP1 SWAP3 SWAP2 SWAP1 DUP2 DUP2 MSTORE PUSH1 0x20 ADD DUP3 DUP1 SLOAD PUSH2 0x9FB SWAP1 PUSH2 0x1C8D JUMP JUMPDEST DUP1 ISZERO PUSH2 0xA48 JUMPI DUP1 PUSH1 0x1F LT PUSH2 0xA1D JUMPI PUSH2 0x100 DUP1 DUP4 SLOAD DIV MUL DUP4 MSTORE SWAP2 PUSH1 0x20 ADD SWAP2 PUSH2 0xA48 JUMP JUMPDEST DUP3 ADD SWAP2 SWAP1 PUSH1 0x0 MSTORE PUSH1 0x20 PUSH1 0x0 KECCAK256 SWAP1 JUMPDEST DUP2 SLOAD DUP2 MSTORE SWAP1 PUSH1 0x1 ADD SWAP1 PUSH1 0x20 ADD DUP1 DUP4 GT PUSH2 0xA2B JUMPI DUP3 SWAP1 SUB PUSH1 0x1F AND DUP3 ADD SWAP2 JUMPDEST POP POP POP POP POP SWAP1 POP SWAP1 JUMP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x1 PUSH1 0x0 PUSH2 0xA61 PUSH2 0xDC5 JUMP JUMPDEST PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 DUP6 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SLOAD SWAP1 POP DUP3 DUP2 LT ISZERO PUSH2 0xB1E JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0xB15 SWAP1 PUSH2 0x1A18 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH2 0xB32 PUSH2 0xB29 PUSH2 0xDC5 JUMP JUMPDEST DUP6 DUP6 DUP5 SUB PUSH2 0xDCD JUMP JUMPDEST PUSH1 0x1 SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0xB51 PUSH2 0xB4A PUSH2 0xDC5 JUMP JUMPDEST DUP5 DUP5 PUSH2 0xF98 JUMP JUMPDEST PUSH1 0x1 SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH8 0xDE0B6B3A7640000 PUSH2 0xD05 CALLVALUE PUSH2 0xB74 SWAP2 SWAP1 PUSH2 0x1B92 JUMP JUMPDEST PUSH2 0xB7E SWAP2 SWAP1 PUSH2 0x1B61 JUMP JUMPDEST SWAP1 POP PUSH1 0x0 DUP2 EQ ISZERO PUSH2 0xBC6 JUMPI CALLVALUE PUSH1 0x40 MLOAD PUSH32 0x97C5F70E00000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0xBBD SWAP2 SWAP1 PUSH2 0x1A58 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH2 0xBD0 CALLER DUP3 PUSH2 0x1219 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 PUSH1 0x40 ADD PUSH1 0x40 MSTORE DUP1 CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 DUP2 MSTORE POP PUSH1 0x6 DUP4 PUSH1 0x40 MLOAD PUSH2 0xC0C SWAP2 SWAP1 PUSH2 0x1860 JUMP JUMPDEST SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 KECCAK256 PUSH1 0x0 DUP3 ADD MLOAD DUP2 PUSH1 0x0 ADD PUSH1 0x0 PUSH2 0x100 EXP DUP2 SLOAD DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF MUL NOT AND SWAP1 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND MUL OR SWAP1 SSTORE POP PUSH1 0x20 DUP3 ADD MLOAD DUP2 PUSH1 0x1 ADD SSTORE SWAP1 POP POP POP POP JUMP JUMPDEST PUSH2 0xC9E PUSH1 0x5 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP3 PUSH2 0xB3D JUMP JUMPDEST POP PUSH1 0x0 PUSH2 0xD05 PUSH8 0xDE0B6B3A7640000 DUP4 PUSH2 0xCB8 SWAP2 SWAP1 PUSH2 0x1B92 JUMP JUMPDEST PUSH2 0xCC2 SWAP2 SWAP1 PUSH2 0x1B61 JUMP JUMPDEST SWAP1 POP CALLER PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH2 0x8FC DUP3 SWAP1 DUP2 ISZERO MUL SWAP1 PUSH1 0x40 MLOAD PUSH1 0x0 PUSH1 0x40 MLOAD DUP1 DUP4 SUB DUP2 DUP6 DUP9 DUP9 CALL SWAP4 POP POP POP POP PUSH2 0xD3A JUMPI CALLER PUSH1 0x40 MLOAD PUSH32 0x810FD2B200000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0xD31 SWAP2 SWAP1 PUSH2 0x1877 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x1 PUSH1 0x0 DUP5 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SLOAD SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 CALLER SWAP1 POP SWAP1 JUMP JUMPDEST PUSH1 0x0 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND EQ ISZERO PUSH2 0xE3D JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0xE34 SWAP1 PUSH2 0x19F8 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x0 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP3 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND EQ ISZERO PUSH2 0xEAD JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0xEA4 SWAP1 PUSH2 0x1978 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST DUP1 PUSH1 0x1 PUSH1 0x0 DUP6 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 DUP5 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 DUP2 SWAP1 SSTORE POP DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH32 0x8C5BE1E5EBEC7D5BD14F71427D1E84F3DD0314C0F7B2291E5B200AC8C7C3B925 DUP4 PUSH1 0x40 MLOAD PUSH2 0xF8B SWAP2 SWAP1 PUSH2 0x1A58 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 LOG3 POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP4 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND EQ ISZERO PUSH2 0x1008 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0xFFF SWAP1 PUSH2 0x19D8 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH1 0x0 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP3 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND EQ ISZERO PUSH2 0x1078 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x106F SWAP1 PUSH2 0x1958 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH2 0x1083 DUP4 DUP4 DUP4 PUSH2 0x1379 JUMP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x0 DUP6 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 SLOAD SWAP1 POP DUP2 DUP2 LT ISZERO PUSH2 0x1109 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x1100 SWAP1 PUSH2 0x1998 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST DUP2 DUP2 SUB PUSH1 0x0 DUP1 DUP7 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 DUP2 SWAP1 SSTORE POP DUP2 PUSH1 0x0 DUP1 DUP6 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 DUP3 DUP3 SLOAD PUSH2 0x119C SWAP2 SWAP1 PUSH2 0x1B0B JUMP JUMPDEST SWAP3 POP POP DUP2 SWAP1 SSTORE POP DUP3 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP5 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH32 0xDDF252AD1BE2C89B69C2B068FC378DAA952BA7F163C4A11628F55A4DF523B3EF DUP5 PUSH1 0x40 MLOAD PUSH2 0x1200 SWAP2 SWAP1 PUSH2 0x1A58 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 LOG3 PUSH2 0x1213 DUP5 DUP5 DUP5 PUSH2 0x137E JUMP JUMPDEST POP POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP3 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND EQ ISZERO PUSH2 0x1289 JUMPI PUSH1 0x40 MLOAD PUSH32 0x8C379A000000000000000000000000000000000000000000000000000000000 DUP2 MSTORE PUSH1 0x4 ADD PUSH2 0x1280 SWAP1 PUSH2 0x1A38 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 REVERT JUMPDEST PUSH2 0x1295 PUSH1 0x0 DUP4 DUP4 PUSH2 0x1379 JUMP JUMPDEST DUP1 PUSH1 0x2 PUSH1 0x0 DUP3 DUP3 SLOAD PUSH2 0x12A7 SWAP2 SWAP1 PUSH2 0x1B0B JUMP JUMPDEST SWAP3 POP POP DUP2 SWAP1 SSTORE POP DUP1 PUSH1 0x0 DUP1 DUP5 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP1 DUP2 MSTORE PUSH1 0x20 ADD PUSH1 0x0 KECCAK256 PUSH1 0x0 DUP3 DUP3 SLOAD PUSH2 0x12FC SWAP2 SWAP1 PUSH2 0x1B0B JUMP JUMPDEST SWAP3 POP POP DUP2 SWAP1 SSTORE POP DUP2 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH1 0x0 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH32 0xDDF252AD1BE2C89B69C2B068FC378DAA952BA7F163C4A11628F55A4DF523B3EF DUP4 PUSH1 0x40 MLOAD PUSH2 0x1361 SWAP2 SWAP1 PUSH2 0x1A58 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 LOG3 PUSH2 0x1375 PUSH1 0x0 DUP4 DUP4 PUSH2 0x137E JUMP JUMPDEST POP POP JUMP JUMPDEST POP POP POP JUMP JUMPDEST POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1396 PUSH2 0x1391 DUP5 PUSH2 0x1AB3 JUMP JUMPDEST PUSH2 0x1A8E JUMP JUMPDEST SWAP1 POP DUP3 DUP2 MSTORE PUSH1 0x20 DUP2 ADD DUP5 DUP5 DUP5 ADD GT ISZERO PUSH2 0x13B2 JUMPI PUSH2 0x13B1 PUSH2 0x1DE0 JUMP JUMPDEST JUMPDEST PUSH2 0x13BD DUP5 DUP3 DUP6 PUSH2 0x1C4B JUMP JUMPDEST POP SWAP4 SWAP3 POP POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 CALLDATALOAD SWAP1 POP PUSH2 0x13D4 DUP2 PUSH2 0x2052 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 CALLDATALOAD SWAP1 POP PUSH2 0x13E9 DUP2 PUSH2 0x2069 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP3 PUSH1 0x1F DUP4 ADD SLT PUSH2 0x1404 JUMPI PUSH2 0x1403 PUSH2 0x1DDB JUMP JUMPDEST JUMPDEST DUP2 CALLDATALOAD PUSH2 0x1414 DUP5 DUP3 PUSH1 0x20 DUP7 ADD PUSH2 0x1383 JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 CALLDATALOAD SWAP1 POP PUSH2 0x142C DUP2 PUSH2 0x2080 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 CALLDATALOAD SWAP1 POP PUSH2 0x1441 DUP2 PUSH2 0x2097 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 DUP5 SUB SLT ISZERO PUSH2 0x145D JUMPI PUSH2 0x145C PUSH2 0x1DEA JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x146B DUP5 DUP3 DUP6 ADD PUSH2 0x13C5 JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x40 DUP4 DUP6 SUB SLT ISZERO PUSH2 0x148B JUMPI PUSH2 0x148A PUSH2 0x1DEA JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x1499 DUP6 DUP3 DUP7 ADD PUSH2 0x13C5 JUMP JUMPDEST SWAP3 POP POP PUSH1 0x20 PUSH2 0x14AA DUP6 DUP3 DUP7 ADD PUSH2 0x13C5 JUMP JUMPDEST SWAP2 POP POP SWAP3 POP SWAP3 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x0 PUSH1 0x60 DUP5 DUP7 SUB SLT ISZERO PUSH2 0x14CD JUMPI PUSH2 0x14CC PUSH2 0x1DEA JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x14DB DUP7 DUP3 DUP8 ADD PUSH2 0x13C5 JUMP JUMPDEST SWAP4 POP POP PUSH1 0x20 PUSH2 0x14EC DUP7 DUP3 DUP8 ADD PUSH2 0x13C5 JUMP JUMPDEST SWAP3 POP POP PUSH1 0x40 PUSH2 0x14FD DUP7 DUP3 DUP8 ADD PUSH2 0x141D JUMP JUMPDEST SWAP2 POP POP SWAP3 POP SWAP3 POP SWAP3 JUMP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x40 DUP4 DUP6 SUB SLT ISZERO PUSH2 0x151E JUMPI PUSH2 0x151D PUSH2 0x1DEA JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x152C DUP6 DUP3 DUP7 ADD PUSH2 0x13C5 JUMP JUMPDEST SWAP3 POP POP PUSH1 0x20 PUSH2 0x153D DUP6 DUP3 DUP7 ADD PUSH2 0x141D JUMP JUMPDEST SWAP2 POP POP SWAP3 POP SWAP3 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 DUP5 SUB SLT ISZERO PUSH2 0x155D JUMPI PUSH2 0x155C PUSH2 0x1DEA JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x156B DUP5 DUP3 DUP6 ADD PUSH2 0x13DA JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 DUP5 SUB SLT ISZERO PUSH2 0x158A JUMPI PUSH2 0x1589 PUSH2 0x1DEA JUMP JUMPDEST JUMPDEST PUSH1 0x0 DUP3 ADD CALLDATALOAD PUSH8 0xFFFFFFFFFFFFFFFF DUP2 GT ISZERO PUSH2 0x15A8 JUMPI PUSH2 0x15A7 PUSH2 0x1DE5 JUMP JUMPDEST JUMPDEST PUSH2 0x15B4 DUP5 DUP3 DUP6 ADD PUSH2 0x13EF JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP1 PUSH1 0x0 DUP1 PUSH1 0x0 DUP1 PUSH1 0xC0 DUP8 DUP10 SUB SLT ISZERO PUSH2 0x15DA JUMPI PUSH2 0x15D9 PUSH2 0x1DEA JUMP JUMPDEST JUMPDEST PUSH1 0x0 DUP8 ADD CALLDATALOAD PUSH8 0xFFFFFFFFFFFFFFFF DUP2 GT ISZERO PUSH2 0x15F8 JUMPI PUSH2 0x15F7 PUSH2 0x1DE5 JUMP JUMPDEST JUMPDEST PUSH2 0x1604 DUP10 DUP3 DUP11 ADD PUSH2 0x13EF JUMP JUMPDEST SWAP7 POP POP PUSH1 0x20 PUSH2 0x1615 DUP10 DUP3 DUP11 ADD PUSH2 0x13DA JUMP JUMPDEST SWAP6 POP POP PUSH1 0x40 PUSH2 0x1626 DUP10 DUP3 DUP11 ADD PUSH2 0x1432 JUMP JUMPDEST SWAP5 POP POP PUSH1 0x60 PUSH2 0x1637 DUP10 DUP3 DUP11 ADD PUSH2 0x13DA JUMP JUMPDEST SWAP4 POP POP PUSH1 0x80 PUSH2 0x1648 DUP10 DUP3 DUP11 ADD PUSH2 0x13DA JUMP JUMPDEST SWAP3 POP POP PUSH1 0xA0 PUSH2 0x1659 DUP10 DUP3 DUP11 ADD PUSH2 0x13C5 JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP6 POP SWAP3 SWAP6 POP SWAP3 SWAP6 JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 DUP5 SUB SLT ISZERO PUSH2 0x167C JUMPI PUSH2 0x167B PUSH2 0x1DEA JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x168A DUP5 DUP3 DUP6 ADD PUSH2 0x141D JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH2 0x169C DUP2 PUSH2 0x1BEC JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH2 0x16AB DUP2 PUSH2 0x1BFE JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH2 0x16BA DUP2 PUSH2 0x1C0A JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x16CB DUP3 PUSH2 0x1AE4 JUMP JUMPDEST PUSH2 0x16D5 DUP2 DUP6 PUSH2 0x1AEF JUMP JUMPDEST SWAP4 POP PUSH2 0x16E5 DUP2 DUP6 PUSH1 0x20 DUP7 ADD PUSH2 0x1C5A JUMP JUMPDEST PUSH2 0x16EE DUP2 PUSH2 0x1DEF JUMP JUMPDEST DUP5 ADD SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1704 DUP3 PUSH2 0x1AE4 JUMP JUMPDEST PUSH2 0x170E DUP2 DUP6 PUSH2 0x1B00 JUMP JUMPDEST SWAP4 POP PUSH2 0x171E DUP2 DUP6 PUSH1 0x20 DUP7 ADD PUSH2 0x1C5A JUMP JUMPDEST DUP1 DUP5 ADD SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1737 PUSH1 0x23 DUP4 PUSH2 0x1AEF JUMP JUMPDEST SWAP2 POP PUSH2 0x1742 DUP3 PUSH2 0x1E00 JUMP JUMPDEST PUSH1 0x40 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x175A PUSH1 0x22 DUP4 PUSH2 0x1AEF JUMP JUMPDEST SWAP2 POP PUSH2 0x1765 DUP3 PUSH2 0x1E4F JUMP JUMPDEST PUSH1 0x40 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x177D PUSH1 0x26 DUP4 PUSH2 0x1AEF JUMP JUMPDEST SWAP2 POP PUSH2 0x1788 DUP3 PUSH2 0x1E9E JUMP JUMPDEST PUSH1 0x40 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x17A0 PUSH1 0x28 DUP4 PUSH2 0x1AEF JUMP JUMPDEST SWAP2 POP PUSH2 0x17AB DUP3 PUSH2 0x1EED JUMP JUMPDEST PUSH1 0x40 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x17C3 PUSH1 0x25 DUP4 PUSH2 0x1AEF JUMP JUMPDEST SWAP2 POP PUSH2 0x17CE DUP3 PUSH2 0x1F3C JUMP JUMPDEST PUSH1 0x40 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x17E6 PUSH1 0x24 DUP4 PUSH2 0x1AEF JUMP JUMPDEST SWAP2 POP PUSH2 0x17F1 DUP3 PUSH2 0x1F8B JUMP JUMPDEST PUSH1 0x40 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1809 PUSH1 0x25 DUP4 PUSH2 0x1AEF JUMP JUMPDEST SWAP2 POP PUSH2 0x1814 DUP3 PUSH2 0x1FDA JUMP JUMPDEST PUSH1 0x40 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x182C PUSH1 0x1F DUP4 PUSH2 0x1AEF JUMP JUMPDEST SWAP2 POP PUSH2 0x1837 DUP3 PUSH2 0x2029 JUMP JUMPDEST PUSH1 0x20 DUP3 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0x184B DUP2 PUSH2 0x1C34 JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH2 0x185A DUP2 PUSH2 0x1C3E JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x186C DUP3 DUP5 PUSH2 0x16F9 JUMP JUMPDEST SWAP2 POP DUP2 SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x188C PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x1693 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x40 DUP3 ADD SWAP1 POP PUSH2 0x18A7 PUSH1 0x0 DUP4 ADD DUP6 PUSH2 0x1693 JUMP JUMPDEST PUSH2 0x18B4 PUSH1 0x20 DUP4 ADD DUP5 PUSH2 0x1842 JUMP JUMPDEST SWAP4 SWAP3 POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x18D0 PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x16A2 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x18EB PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x16B1 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x80 DUP3 ADD SWAP1 POP PUSH2 0x1906 PUSH1 0x0 DUP4 ADD DUP8 PUSH2 0x16B1 JUMP JUMPDEST PUSH2 0x1913 PUSH1 0x20 DUP4 ADD DUP7 PUSH2 0x1851 JUMP JUMPDEST PUSH2 0x1920 PUSH1 0x40 DUP4 ADD DUP6 PUSH2 0x16B1 JUMP JUMPDEST PUSH2 0x192D PUSH1 0x60 DUP4 ADD DUP5 PUSH2 0x16B1 JUMP JUMPDEST SWAP6 SWAP5 POP POP POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1950 DUP2 DUP5 PUSH2 0x16C0 JUMP JUMPDEST SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1971 DUP2 PUSH2 0x172A JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1991 DUP2 PUSH2 0x174D JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x19B1 DUP2 PUSH2 0x1770 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x19D1 DUP2 PUSH2 0x1793 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x19F1 DUP2 PUSH2 0x17B6 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1A11 DUP2 PUSH2 0x17D9 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1A31 DUP2 PUSH2 0x17FC JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP DUP2 DUP2 SUB PUSH1 0x0 DUP4 ADD MSTORE PUSH2 0x1A51 DUP2 PUSH2 0x181F JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x1A6D PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x1842 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x1A88 PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x1851 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1A98 PUSH2 0x1AA9 JUMP JUMPDEST SWAP1 POP PUSH2 0x1AA4 DUP3 DUP3 PUSH2 0x1CBF JUMP JUMPDEST SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x40 MLOAD SWAP1 POP SWAP1 JUMP JUMPDEST PUSH1 0x0 PUSH8 0xFFFFFFFFFFFFFFFF DUP3 GT ISZERO PUSH2 0x1ACE JUMPI PUSH2 0x1ACD PUSH2 0x1DAC JUMP JUMPDEST JUMPDEST PUSH2 0x1AD7 DUP3 PUSH2 0x1DEF JUMP JUMPDEST SWAP1 POP PUSH1 0x20 DUP2 ADD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 MLOAD SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP3 DUP3 MSTORE PUSH1 0x20 DUP3 ADD SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1B16 DUP3 PUSH2 0x1C34 JUMP JUMPDEST SWAP2 POP PUSH2 0x1B21 DUP4 PUSH2 0x1C34 JUMP JUMPDEST SWAP3 POP DUP3 PUSH32 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF SUB DUP3 GT ISZERO PUSH2 0x1B56 JUMPI PUSH2 0x1B55 PUSH2 0x1D1F JUMP JUMPDEST JUMPDEST DUP3 DUP3 ADD SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1B6C DUP3 PUSH2 0x1C34 JUMP JUMPDEST SWAP2 POP PUSH2 0x1B77 DUP4 PUSH2 0x1C34 JUMP JUMPDEST SWAP3 POP DUP3 PUSH2 0x1B87 JUMPI PUSH2 0x1B86 PUSH2 0x1D4E JUMP JUMPDEST JUMPDEST DUP3 DUP3 DIV SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1B9D DUP3 PUSH2 0x1C34 JUMP JUMPDEST SWAP2 POP PUSH2 0x1BA8 DUP4 PUSH2 0x1C34 JUMP JUMPDEST SWAP3 POP DUP2 PUSH32 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF DIV DUP4 GT DUP3 ISZERO ISZERO AND ISZERO PUSH2 0x1BE1 JUMPI PUSH2 0x1BE0 PUSH2 0x1D1F JUMP JUMPDEST JUMPDEST DUP3 DUP3 MUL SWAP1 POP SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH2 0x1BF7 DUP3 PUSH2 0x1C14 JUMP JUMPDEST SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 ISZERO ISZERO SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF DUP3 AND SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0xFF DUP3 AND SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST DUP3 DUP2 DUP4 CALLDATACOPY PUSH1 0x0 DUP4 DUP4 ADD MSTORE POP POP POP JUMP JUMPDEST PUSH1 0x0 JUMPDEST DUP4 DUP2 LT ISZERO PUSH2 0x1C78 JUMPI DUP1 DUP3 ADD MLOAD DUP2 DUP5 ADD MSTORE PUSH1 0x20 DUP2 ADD SWAP1 POP PUSH2 0x1C5D JUMP JUMPDEST DUP4 DUP2 GT ISZERO PUSH2 0x1C87 JUMPI PUSH1 0x0 DUP5 DUP5 ADD MSTORE JUMPDEST POP POP POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x2 DUP3 DIV SWAP1 POP PUSH1 0x1 DUP3 AND DUP1 PUSH2 0x1CA5 JUMPI PUSH1 0x7F DUP3 AND SWAP2 POP JUMPDEST PUSH1 0x20 DUP3 LT DUP2 EQ ISZERO PUSH2 0x1CB9 JUMPI PUSH2 0x1CB8 PUSH2 0x1D7D JUMP JUMPDEST JUMPDEST POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0x1CC8 DUP3 PUSH2 0x1DEF JUMP JUMPDEST DUP2 ADD DUP2 DUP2 LT PUSH8 0xFFFFFFFFFFFFFFFF DUP3 GT OR ISZERO PUSH2 0x1CE7 JUMPI PUSH2 0x1CE6 PUSH2 0x1DAC JUMP JUMPDEST JUMPDEST DUP1 PUSH1 0x40 MSTORE POP POP POP JUMP JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x1 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x11 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x12 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x22 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH32 0x4E487B7100000000000000000000000000000000000000000000000000000000 PUSH1 0x0 MSTORE PUSH1 0x41 PUSH1 0x4 MSTORE PUSH1 0x24 PUSH1 0x0 REVERT JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH1 0x0 PUSH1 0x1F NOT PUSH1 0x1F DUP4 ADD AND SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH32 0x45524332303A207472616E7366657220746F20746865207A65726F2061646472 PUSH1 0x0 DUP3 ADD MSTORE PUSH32 0x6573730000000000000000000000000000000000000000000000000000000000 PUSH1 0x20 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH32 0x45524332303A20617070726F766520746F20746865207A65726F206164647265 PUSH1 0x0 DUP3 ADD MSTORE PUSH32 0x7373000000000000000000000000000000000000000000000000000000000000 PUSH1 0x20 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH32 0x45524332303A207472616E7366657220616D6F756E7420657863656564732062 PUSH1 0x0 DUP3 ADD MSTORE PUSH32 0x616C616E63650000000000000000000000000000000000000000000000000000 PUSH1 0x20 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH32 0x45524332303A207472616E7366657220616D6F756E7420657863656564732061 PUSH1 0x0 DUP3 ADD MSTORE PUSH32 0x6C6C6F77616E6365000000000000000000000000000000000000000000000000 PUSH1 0x20 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH32 0x45524332303A207472616E736665722066726F6D20746865207A65726F206164 PUSH1 0x0 DUP3 ADD MSTORE PUSH32 0x6472657373000000000000000000000000000000000000000000000000000000 PUSH1 0x20 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH32 0x45524332303A20617070726F76652066726F6D20746865207A65726F20616464 PUSH1 0x0 DUP3 ADD MSTORE PUSH32 0x7265737300000000000000000000000000000000000000000000000000000000 PUSH1 0x20 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH32 0x45524332303A2064656372656173656420616C6C6F77616E63652062656C6F77 PUSH1 0x0 DUP3 ADD MSTORE PUSH32 0x207A65726F000000000000000000000000000000000000000000000000000000 PUSH1 0x20 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH32 0x45524332303A206D696E7420746F20746865207A65726F206164647265737300 PUSH1 0x0 DUP3 ADD MSTORE POP JUMP JUMPDEST PUSH2 0x205B DUP2 PUSH2 0x1BEC JUMP JUMPDEST DUP2 EQ PUSH2 0x2066 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP JUMPDEST PUSH2 0x2072 DUP2 PUSH2 0x1C0A JUMP JUMPDEST DUP2 EQ PUSH2 0x207D JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP JUMPDEST PUSH2 0x2089 DUP2 PUSH2 0x1C34 JUMP JUMPDEST DUP2 EQ PUSH2 0x2094 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP JUMPDEST PUSH2 0x20A0 DUP2 PUSH2 0x1C3E JUMP JUMPDEST DUP2 EQ PUSH2 0x20AB JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP INVALID LOG2 PUSH5 0x6970667358 0x22 SLT KECCAK256 0xE8 GASLIMIT 0xD0 0x2E 0x29 PUSH6 0x1A259EE8E5EF EXP 0xE RETURN GASLIMIT SWAP13 0xF ORIGIN POP 0x4C CODECOPY 0xBA 0xB0 KECCAK256 0xCB PUSH20 0x7A987A9B4464736F6C6343000807003300000000 \",\n"
            + "\t\"sourceMap\": \"128:2093:4:-:0;;;1963:113:0;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;2037:5;2029;:13;;;;;;;;;;;;:::i;:::-;;2062:7;2052;:17;;;;;;;;;;;;:::i;:::-;;1963:113;;474:10:4::1;466:5;;:18;;;;;;;;;;;;;;;;;;128:2093:::0;;;;;;;;;:::i;:::-;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;:::i;:::-;;;:::o;:::-;;;;;;;;;;;;;;;;;;;;;:::o;7:320:5:-;51:6;88:1;82:4;78:12;68:22;;135:1;129:4;125:12;156:18;146:81;;212:4;204:6;200:17;190:27;;146:81;274:2;266:6;263:14;243:18;240:38;237:84;;;293:18;;:::i;:::-;237:84;58:269;7:320;;;:::o;333:180::-;381:77;378:1;371:88;478:4;475:1;468:15;502:4;499:1;492:15;128:2093:4;;;;;;;\"\n"
            + "}");



    public static final String BINARY = builder.toString();
    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_DECREASEALLOWANCE = "decreaseAllowance";

    public static final String FUNC_INCREASEALLOWANCE = "increaseAllowance";

    public static final String FUNC_ONCLICK = "onClick";

    public static final String FUNC_POSTAD = "postAd";

    public static final String FUNC_REDEEM = "redeem";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_IMPRESSIONIDS = "impressionIds";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_POSTINGS = "postings";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_VENDO = "vendo";

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected Vendo(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Vendo(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Vendo(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Vendo(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String spender, BigInteger amount) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new Address(160, spender),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> decreaseAllowance(String spender, BigInteger subtractedValue) {
        final Function function = new Function(
                FUNC_DECREASEALLOWANCE, 
                Arrays.<Type>asList(new Address(160, spender),
                new Uint256(subtractedValue)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> increaseAllowance(String spender, BigInteger addedValue) {
        final Function function = new Function(
                FUNC_INCREASEALLOWANCE, 
                Arrays.<Type>asList(new Address(160, spender),
                new Uint256(addedValue)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> onClick(String adId, byte[] hashMessage, BigInteger v, byte[] r, byte[] s, String integrator) {
        final Function function = new Function(
                FUNC_ONCLICK, 
                Arrays.<Type>asList(new Utf8String(adId),
                new org.web3j.abi.datatypes.generated.Bytes32(hashMessage), 
                new Uint8(v),
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s), 
                new Address(160, integrator)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> postAd(String adId, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_POSTAD, 
                Arrays.<Type>asList(new Utf8String(adId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> redeem(BigInteger tokens) {
        final Function function = new Function(
                FUNC_REDEEM, 
                Arrays.<Type>asList(new Uint256(tokens)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transfer(String recipient, BigInteger amount) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new Address(160, recipient),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> {
            EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = log;
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            return typedResponse;
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String sender, String recipient, BigInteger amount) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new Address(160, sender),
                new Address(160, recipient),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> allowance(String owner, String spender) {
        final Function function = new Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new Address(160, owner),
                new Address(160, spender)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String account) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new Address(160, account)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> decimals() {
        final Function function = new Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> impressionIds(byte[] param0) {
        final Function function = new Function(FUNC_IMPRESSIONIDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple2<String, BigInteger>> postings(String param0) {
        final Function function = new Function(FUNC_POSTINGS, 
                Arrays.<Type>asList(new Utf8String(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<String, BigInteger>>(function,
                new Callable<Tuple2<String, BigInteger>>() {
                    @Override
                    public Tuple2<String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> totalSupply() {
        final Function function = new Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> vendo() {
        final Function function = new Function(FUNC_VENDO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Vendo load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Vendo(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Vendo load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Vendo(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Vendo load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Vendo(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Vendo load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Vendo(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Vendo> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Vendo.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Vendo> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Vendo.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Vendo> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Vendo.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Vendo> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Vendo.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger value;
    }
}
