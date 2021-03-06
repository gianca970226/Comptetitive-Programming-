import sys
def main():
    table = [0] * 1000001
    for line in sys.stdin:
        try:
            x, y = line.split()
        except Exception:
            print("Invalid input")
            break
        i = int(x)
        b = int(y)
        if i > b:
            v = b
            b = i
            i = v
        max = 0
        if i > 0 and i < 1000000 and b > 0 and b < 1000000:
            for s in range(i, b + 1):
                if not table[s]:
                    aux = 1
                    a = s
                    while a > 1:
                        aux = aux + 1
                        if a % 2 == 0:
                            a = a / 2
                        else:
                            a = (3 * a) + 1
                    table[s] = aux
                else:
                    aux = table[s]
                if max <= aux:
                    max = aux
            print(x, y, max)
        else:
            print("Invalid input")
            break


if __name__ == '__main__':
    main()