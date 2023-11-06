#include "Rectangle.h"
#include <sstream>

Rectangle::Rectangle(double width, double height) : _width(width), _height(height) {}

std::string Rectangle::name() const {
    return "Rectangle of width " + std::to_string(_width) + " and height " + std::to_string(_height);
}

double Rectangle::area() const {
    return _width * _height;
}


