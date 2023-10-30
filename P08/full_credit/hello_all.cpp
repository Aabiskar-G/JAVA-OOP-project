#include<string>
#include<iostream>

using std::string;
using std::cout;
using std::getline;
using std::cin;



int main()
{
    string s1;
    cout<<"What's your name?\n Enter your name:";
    getline(cin, s1);
    cout<< "Hello, " << s1 << std::endl;
}

