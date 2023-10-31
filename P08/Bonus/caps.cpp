#include <iostream>
#include <string>
#include <vector>


int main(int argc, char* argv[]) {
    // Create vectors
    std::vector<std::string> caps; // on the stack
    std::vector<std::string>* no_caps = new std::vector<std::string>; // on the heap

    // Iterate over the program arguments
    for (int i = 1; i < argc; i++) {
        std::string arg(argv[i]);
        if (isupper(arg[0])) { // Check if the first character is uppercase
            caps.push_back(arg);
        } else {
            no_caps->push_back(arg);
        }
    }

    // Print capitalized arguments
    std::cout << "Capitalized:" << std::endl;
    for (const auto& word : caps) {
        std::cout << word << std::endl;
    }

    // Print lowercase arguments
    std::cout << "\n\nLower Case:" << std::endl;
    for (const auto& word : *no_caps) {
        std::cout << word << std::endl;
    }

    delete no_caps; // Free memory allocated on the heap
    return 0;
}
