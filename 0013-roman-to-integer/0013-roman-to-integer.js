var romanToInt = function(s) {
    const sym = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    };
    
    let total = 0;
    
    for (let i = 0; i < s.length; i++) {
        const current = sym[s[i]];
        const next = sym[s[i + 1]];
        
        if (current < next) {
            total -= current;
        } else {
            total += current;
        }
    }
    
    return total;
};