/*
 * Copyright 2019 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.web3j.crypto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TypedDataTest {

    private static String jsonMessageString;

    @BeforeEach
    public void validSetUp() throws IOException, RuntimeException {
        String validStructuredDataJSONFilePath =
                "build/resources/test/" + "structured_data_json_files/WalletConnectExample.json";
        jsonMessageString = getResource(validStructuredDataJSONFilePath);
    }

    private String getResource(String jsonFile) throws IOException {
        return new String(
                Files.readAllBytes(Paths.get(jsonFile).toAbsolutePath()), StandardCharsets.UTF_8);
    }

    @Test
    public void testEncode() throws IOException, RuntimeException {
        StructuredDataEncoder dataEncoder = new StructuredDataEncoder(jsonMessageString);
        dataEncoder.hashStructuredData();
    }
}
