#include <iostream>
#include <stdio.h>
#include <bits/stdc++.h>
using namespace std;

int main()
{
	int t;
	t = 100;
	cout<<t<<endl;
	 srand(time(0)); 
	while(t--)
	{
		int n,k;
		n = rand()%100000+1;
		k = rand()%(min(n,5));
		cout<<n<<" "<<k<<endl;
		for(int i=0;i<n;i++)
		{
			int j = rand()%100;
			cout<<(j==99 || j==98)<<" ";
		}
		cout<<endl;
		
	}
	return 0;
}

