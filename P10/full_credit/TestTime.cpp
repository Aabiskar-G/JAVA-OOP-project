#include "Time.h"
#include <iostream>
#include <sstream>
#include <vector>

bool fails(const Time& result, std::string expected) {
    std::ostringstream oss;
    oss << result; // convert time to a string
    if(oss.str() == expected) {
        std::cout << "PASS: " << result << " == " << expected << std::endl;
        return false;
    }
    std::cerr << "FAIL: expected '" << expected
              << "' but got '" << oss.str() << "'" << std::endl;
    return true;
}

void fails(const Time& t1, const Time& t2, std::string op, bool condition) {
    std::cout << "Testing: " << t1 << " " << op << " " << t2 << " ... ";
    if (condition) {
        std::cout << "PASS" << std::endl;
    } else {
        std::cerr << "FAIL" << std::endl;
    }
}

int main(int argc, char* argv[]) {
    int result = 0;

    // Test constructors and operator<<
    if(fails(Time{}, "00:00:00")) result |= 1;
    if(fails(Time{23,59,59}, "23:59:59")) result |= 1;

    // Test operator>>, operator<<
    std::vector<std::string> times {"00:00:00", "23:59:59", "01:00:00", "23:00:00", "00:01:00", "00:59:00", "00:00:01", "00:00:59"};
    Time time;
    for(const std::string& expected : times) {
        std::istringstream iss{expected};
        iss >> time;
        if(fails(time, expected)) result |= 2;
    }

    // Test rationalization
    if(fails(Time{3,4,60}, "03:05:00")) result |= 4;
    if(fails(Time{3,4,-1}, "03:03:59")) result |= 4;

    // Test addition
    if(fails(Time{1, 2, 3} + Time{6, 5, 4}, "07:07:07")) result |= 8;
    if(fails(Time{12,29,59} + Time{0, 0, 1}, "12:30:00")) result |= 8;

    // Test increment
    if(fails(++Time{12, 30, 59}, "12:31:00")) result |= 16;
    if(fails(Time{12, 30, 59}++, "12:30:59")) result |= 16;
    if(fails(++Time{23, 59, 59}, "00:00:00")) result |= 16;
    if(fails(++Time{ 0,  0,  0}, "00:00:01")) result |= 16;

    // Test comparison
    Time t0{12,30,0};
    Time t1{12,30,0};
    Time t2{12,30,1};

    fails(t1, t2, "==", t1 == t2); if(t1 == t2) result |= 32;
    fails(t0, t1, "==", t0 == t1); if(!(t0 == t1)) result |= 32;
    fails(t0, t1, "<=", t0 <= t1); if(!(t0 <= t1)) result |= 32;
    fails(t0, t1, ">=", t0 >= t1); if(!(t0 >= t1)) result |= 32;
    fails(t0, t1, "!=", t0 != t1); if(t0 != t1) result |= 32;
    fails(t1, t2, "> ", t1 > t2);  if(t1 > t2) result |= 32;
    fails(t1, t2, ">=", t1 >= t2); if(t1 >= t2) result |= 32;
    fails(t1, t2, "< ", t1 < t2);  if(t2 < t1) result |= 32;
    fails(t1, t2, "<=", t1 <= t2); if(t2 <= t1) result |= 32;
    
    
    // Report overall result
    if(result != 0) std::cerr << "FAIL with error code " << result << std::endl;
    return result;
}


