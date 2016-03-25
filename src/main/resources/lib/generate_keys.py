#!/usr/bin/python
# coding: utf-8

if __name__ == "__main__":

    import random

    f = open('../keys.out', 'w')

    for it in range(10000):
        array = random.sample(range(0, 99), 50)
        f.write(' '.join(str(x) for x in array))
        f.write('\n')

    f.close()
