/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    var prev = n;
    return function() {
        return prev ++;
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */