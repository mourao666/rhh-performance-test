/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.ufu.pgcc.sc.cassandrasim.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Resources
{
    public static String readKeys()
    {
        return readFile("keys.out");
    }

    public static String readVectors()
    {
        return readFile("vectors.out");
    }

    private static String readFile(String filename)
    {
        ClassLoader classLoader = Resources.class.getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());

        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();

        try
        {
            reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null)
            {
                if (!line.isEmpty())
                    builder.append(line).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (reader != null)
                    reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }

        return builder.toString();
    }
}
