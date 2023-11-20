#include "Index.h"
#include <fstream>
#include <sstream>
#include <cctype>
#include <algorithm>

// Helper function to clean and process each word
std::string clean_word(std::string word) {
    // Remove punctuation from the start and end of the word
    while (!word.empty() && ispunct(word.front())) {
        word.erase(0, 1);
    }
    while (!word.empty() && ispunct(word.back())) {
        word.pop_back();
    }

    // Convert to lowercase
    std::transform(word.begin(), word.end(), word.begin(), 
                   [](unsigned char c){ return std::tolower(c); });

    return word;
}

int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cerr << "Usage: " << argv[0] << " [file1] [file2] ..." << std::endl;
        return 1;
    }

    Index index;

    for (int i = 1; i < argc; ++i) {
        std::string filename(argv[i]);
        std::ifstream file(filename);
        if (!file) {
            std::cerr << "Error opening file: " << filename << std::endl;
            continue;
        }

        std::string line;
        int line_number = 0;
        while (std::getline(file, line)) {
            line_number++;
            std::istringstream iss(line);
            std::string word;
            while (iss >> word) {
                word = clean_word(word);
                if (!word.empty()) {
                    index.add_word(word, Location(filename, line_number));
                }
            }
        }
    }

    std::cout << index;

    return 0;
}

