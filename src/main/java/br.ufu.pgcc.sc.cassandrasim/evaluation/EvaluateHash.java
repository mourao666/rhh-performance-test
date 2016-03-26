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

package br.ufu.pgcc.sc.cassandrasim.evaluation;

import java.nio.ByteBuffer;
import java.util.BitSet;

import br.ufu.pgcc.sc.cassandrasim.gray.BinaryReflectedGrayCodeUtil;
import br.ufu.pgcc.sc.cassandrasim.hash.MurmurHash;
import br.ufu.pgcc.sc.cassandrasim.hash.RandomHyperplaneHash;

public class EvaluateHash
{
    public long rhh(ByteBuffer[] keys, double[][] vectors)
    {
        long time = System.nanoTime();
        for (ByteBuffer key : keys)
        {
            BitSet gray = RandomHyperplaneHash.rhh(key, vectors.length, vectors);
            BitSet binary = BinaryReflectedGrayCodeUtil.grayToBinary(gray);
        }
        return System.nanoTime() - time;
    }

    public long murmur(ByteBuffer[] keys)
    {
        long time = System.nanoTime();
        for (ByteBuffer key : keys)
        {
            long[] hash = new long[2];
            MurmurHash.hash3_x64_128(key, key.position(), key.remaining(), 0, hash);
        }
        return System.nanoTime() - time;
    }
}
