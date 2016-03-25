#!/usr/bin/python
# coding: utf-8

if __name__ == "__main__":

    import numpy as np

    f = open('../vectors.out', 'w')

    for it in range(16):
        array = np.random.uniform(low=0.0, high=1.0, size=(50,))
        f.write(' '.join(str(x) for x in array))
        f.write('\n')

    f.close()
