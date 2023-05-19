for (int v : nodes) {
if (setA.contains(v)) {
flag = true;
break;
}
}
if (flag) {
setA.addAll(Arrays.stream(nodes).boxed().collect(Collectors.toSet()));
setB.add(vertex);
} else {
setA.add(vertex);
setB.addAll(Arrays.stream(nodes).boxed().collect(Collectors.toSet()));
}
} else if (setA.contains(vertex)) {
setB.addAll(Arrays.stream(nodes).boxed().collect(Collectors.toSet()));
} else if (setB.contains(vertex)) {
setA.addAll(Arrays.stream(nodes).boxed().collect(Collectors.toSet()));
}
}
}
​
return (setA.size() + setB.size()) == graph.length;
}
}
```