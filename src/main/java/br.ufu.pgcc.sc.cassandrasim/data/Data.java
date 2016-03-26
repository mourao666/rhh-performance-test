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

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Data
{
    public static final double[][] VECTORS = getVectors();
    public static final ByteBuffer[] KEYS = getKeys();

    private static double[][] getVectors()
    {
        String vectorsLines[] = Resources.readVectors().split("\n");
        double[][] vectors = new double[vectorsLines.length][];

        for (int i = 0; i < vectorsLines.length; i++)
        {
            String[] vectorLine = vectorsLines[i].split(" ");
            double[] vector = new double[vectorLine.length];

            for (int j = 0; j < vectorLine.length; j++)
            {
                vector[j] = Double.parseDouble(vectorLine[j]);
            }

            vectors[i] = vector;
        }

        return vectors;
    }

    private static ByteBuffer[] getKeys()
    {
        String keysLines[] = Resources.readKeys().split("\n");
        ByteBuffer[] keys = new ByteBuffer[keysLines.length];

        for (int i = 0; i < keysLines.length; i++)
        {
            String[] keyLine = keysLines[i].split(" ");
            int[] key = new int[keyLine.length];

            for (int j = 0; j < keyLine.length; j++)
            {
                key[j] = Integer.parseInt(keyLine[j]);
            }

            ByteBuffer byteBuffer = ByteBuffer.allocate(key.length * 4);
            IntBuffer intBuffer = byteBuffer.asIntBuffer();
            intBuffer.put(key);
            keys[i] = byteBuffer;
        }

        return keys;
    }
}
