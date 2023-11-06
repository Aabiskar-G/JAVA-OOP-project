#include "Circle.h"
#include <sstream>
#include <cmath>

Circle::Circle(double radius) : _radius(radius) {}
std::string Circle::name() const {
    return "Circle of radius " + std::to_string(_radius);
}


double Circle::area() const {
    return M_PI * _radius * _radius;
}

