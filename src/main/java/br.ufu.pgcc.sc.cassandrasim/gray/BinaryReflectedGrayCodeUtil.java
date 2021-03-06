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

package br.ufu.pgcc.sc.cassandrasim.gray;

import java.util.BitSet;

public class BinaryReflectedGrayCodeUtil
{
    private static final BitSet ZERO = new BitSet();

    public static BitSet binaryToGray(BitSet binary)
    {
        if (binary.equals(ZERO))
        {
            return (BitSet) ZERO.clone();
        }
        else
        {
            BitSet gray = (BitSet) binary.clone();
            gray.xor(binary.get(1, binary.length()));
            return gray;
        }
    }

    public static BitSet grayToBinary(BitSet gray)
    {
        if (gray.equals(ZERO))
        {
            return (BitSet) ZERO.clone();
        }
        else
        {
            BitSet binary = (BitSet) gray.clone();
            BitSet bs = gray.get(1, gray.length());

            while (!bs.equals(ZERO))
            {
                binary.xor(bs);
                bs = bs.get(1, bs.length());
            }

            return binary;
        }
    }
}
