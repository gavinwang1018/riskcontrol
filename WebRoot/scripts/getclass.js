//µÃµ½css class
function getElementsByClassName(ele,className) {
  if(document.all){
    var children = ele.all;
  }else{
    var children = ele.getElementsByTagName('*');
  }
  var elements = new Array();
  for (var i = 0; i < children.length; i++) {
    var child = children[i];
    var classNames = child.className.split(' ');
    for (var j = 0; j < classNames.length; j++) {
      if (classNames[j] == className) {
        elements[elements.length] = child;
        break;
      }
    }
  }
  return elements;
}