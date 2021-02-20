#46232779
#Не удалось преодолеть барьеры финальных задач А и С по времени и памяти на джаве
#сдать задачу на питоне мой последний шанс продолжить обучение

def unpack(s):
    if all(97 <= ord(ch) <= 122 for ch in s):
        return s
    new = ""
    i = 0
        
    while i < len(s):
        if 97 <= ord(s[i]) <= 122:
            new += s[i]
            i += 1
        else:
            mul = ""
            while s[i] != "[":
                mul += s[i]
                i += 1
            mul = int(mul)
            beg = i + 1
            end = beg
            sm = 1
            while sm != 0:
                if s[end] == "[":
                    sm += 1
                elif s[end] == "]":
                    sm -= 1
                end += 1
            i = end
            new += mul*unpack(s[beg:end-1])
    return new

# Longest common prefix
def LCP(strs):
    if not strs:
        return ""
    shortest_str = min(strs, key=len)
    for i, char in enumerate(shortest_str):
        for other in strs:
            if other[i] != char:
                return shortest_str[:i]
    return shortest_str

n = int(input())
array = []
for _ in range(n):
    array.append(unpack(input()))

print(LCP(array))
