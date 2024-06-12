def max_sum_subarrays(A, N, K):
    max_sum = float('-inf')
    for i in range(1, N):
        sum1 = sum(A[:i])
        sum2 = sum(A[i:])
        max_sum = max(max_sum, sum1 - sum2)
    return max_sum

def main():
    T = int(input().strip())
    for _ in range(T):
        N = int(input().strip())
        A = list(map(int, input().split()))
        K = int(input().strip())
        
        result = max_sum_subarrays(A, N, K)
        print(result)

if __name__ == "__main__":
    main()
