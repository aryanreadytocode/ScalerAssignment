def second_largest(arr,n):
    ans = None
    # YOUR CODE GOES HERE
    mx=max(arr[0],arr[1])
    ans=min(arr[0],arr[1])
    n =len(arr)
    for i in range(2,n):
        if arr[i]>mx:
            ans=mx
            mx=arr[i]
        elif arr[i]>ans and \
            mx != arr[i]:
            ans=arr[i]
    return ans