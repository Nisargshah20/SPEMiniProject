#include <iostream>
#include <stdio.h>
#include <bits/stdc++.h>
using namespace std;

int main()
{
	int t;
	t = 1000;
	cout<<t<<endl;
	 srand(time(0)); 
	while(t--)
	{
		int i,j;
		j = rand()%1000+1;
		for(i=0;i<j;i++)
		{
			int k = rand()%2;
			if(k==1)cout<<"a";else cout<<"b";
		}
		cout<<endl;
		
	}
	return 0;
}

