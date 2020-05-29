#include <iostream>
#include <bits/stdc++.h>
using namespace std;

bool kLengthApart(vector<int>& nums, int k) 
{
        
        int start = -1
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]==1)
            {
                if(start!=-1 && i-start<=k)return 0; 
                start = i;
            }
        }
        return 1;
}
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n,k;
		cin>>n>>k;
		int i,j;
		vector<int>nums;
		for(i=0;i<n;i++)
		{
			cin>>j;nums.push_back(j);
		}
		cout<<kLengthApart(nums,k)<<endl;
	}
}

