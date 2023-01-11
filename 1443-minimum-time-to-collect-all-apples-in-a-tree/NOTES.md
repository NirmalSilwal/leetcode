```
int noAppleCount = 0;
for (boolean apple : hasApple) {
if (!apple) noAppleCount++;
}
if (noAppleCount == hasApple.size()) return 0;
```