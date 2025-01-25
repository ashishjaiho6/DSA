var mergeTwoLists = function (list1, list2) {
  const newArray = [...list1, ...list2];
  const ss = newArray.sort((a, b) => a - b);
  return ss;
};

console.log(mergeTwoLists([], [0]));

// Output: [1,1,2,3,4,4]
