#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"
#include <iostream>
#include <vector>
#include <memory>

int main() {
    std::vector<std::unique_ptr<Shape>> shapes;
    shapes.push_back(std::make_unique<Rectangle>(4.0, 5.0));
    shapes.push_back(std::make_unique<Circle>(3.0));

    for (const auto& shape : shapes) {
        std::cout << shape->to_string() << std::endl;
    }

    return 0;
}


