#include <iostream>
#include <vector>
#include <string>
#include <algorithm>




using std::cout;
using std::vector;
using std::sort;


// Comparator function for sorting no_caps vector
bool customCompare(const std::string& a, const std::string& b) {
    if (a.length() == b.length()) {
        return a < b;  // If lengths are the same, sort by natural order
    }
    return a.length() < b.length();  // Sort by length otherwise
}

int main(int argc, char* argv[]) {
    // Create vectors
    vector<std::string> caps; // on the stack
    vector<std::string>* no_caps = new vector<std::string>; // on the heap

    // Iterate over the program arguments
    for (int i = 1; i < argc; i++) {
        std::string arg(argv[i]);
        if (isupper(arg[0])) {
            caps.push_back(arg);
        } else {
            no_caps->push_back(arg);
        }
    }

    // Sort the vectors
    sort(caps.begin(), caps.end());  // Natural order for caps
    sort(no_caps->begin(), no_caps->end(), customCompare);  // Custom order for no_caps

    // Print capitalized arguments
    cout << "\nCapitalized:" << std::endl;
    for (const auto& word : caps) {
        std::cout << word << std::endl;
    }

    // Print lowercase arguments
    cout << "\n\nLower Case:" << std::endl;
    for (const auto& word : *no_caps) {
        cout << word << std::endl;
    }

    delete no_caps; // Free memory allocated on the heap
    return 0;
}

