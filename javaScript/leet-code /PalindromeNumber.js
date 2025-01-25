var isPalindrome = function (x) {
  if (x < 0) {
    return false;
  }

  const y = x.toString();

  let string = "";
  for (let index = y.length - 1; index > -1; index--) {
    string += y[index];
  }

  if (y == string) {
    return true;
  }
  return false;
};

console.log(isPalindrome(12321));
