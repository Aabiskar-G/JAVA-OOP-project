#include "Index.h"
#include <ostream> 
#include <optional>


void Index::add_word(const std::string& word, const Location& location) {
    _index.insert(std::make_pair(word, location));
}

std::ostream& operator<<(std::ostream& os, const Index& index) {
    std::string last_word;
    std::optional<Location> last_location; // Using std::optional for last_location

    for (const auto& pair : index._index) {
        if (pair.first != last_word || !last_location.has_value() || pair.second != last_location.value()) {
            if (pair.first != last_word) {
                if (!last_word.empty()) {
                    os << std::endl;
                }
                os << pair.first << ": ";
                last_word = pair.first;
            }
            os << pair.second << " ";
            last_location = pair.second;
        }
    }
    return os << std::endl;
}



