#include "Index.h"
#include <algorithm>

void Index::add_word(const std::string& word, const Location& location) {
    _index[word].insert(location);
}

std::ostream& operator<<(std::ostream& os, const Index& index) {
    for (const auto& pair : index._index) {
        os << pair.first << ": ";
        for (const auto& loc : pair.second) {
            os << loc << ", ";
        }
        os << std::endl;
    }
    return os;
}

