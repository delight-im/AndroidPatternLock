# AndroidPatternLock

List of all combinations for the Android pattern lock

## Model

```
(1)(2)(3)
(4)(5)(6)
(7)(8)(9)
```

## Number of possible combinations

### by maximum number of connected dots

 * 4 dots: 1,624 combinations
 * up to 5 dots: 8,776 combinations
 * up to 6 dots: 34,792 combinations
 * up to 7 dots: 107,704 combinations
 * up to 8 dots: 248,408 combinations
 * up to 9 dots: 389,112 combinations

### per single number of connected dots

 * exactly 4 dots: 1,624 combinations
 * exactly 5 dots: 7,152 combinations
 * exactly 6 dots: 26,016 combinations
 * exactly 7 dots: 72,912 combinations
 * exactly 8 dots: 140,704 combinations
 * exactly 9 dots: 140,704 combinations

## List of possible combinations ([Full list](combinations/all.txt))

```
1234
12345
123456
1234567
12345678
123456789
1234568
12345687
123456879
12345689
...
```

### Filtering

#### For an exact number of connected dots ([Filtered lists](combinations/Exact%20number%20of%20connected%20dots/))

```bash
# Exactly 4 connected dots
$ grep -E '^.{4}$' 'combinations/all.txt'
```

#### For a minimum number of connected dots ([Filtered lists](combinations/Minimum%20number%20of%20connected%20dots/))

```bash
# At least 8 connected dots
$ grep -E '^.{8,}$' 'combinations/all.txt'
```

#### For a maximum number of connected dots ([Filtered lists](combinations/Maximum%20number%20of%20connected%20dots/))

```bash
# At most 7 connected dots
$ grep -E '^.{,7}$' 'combinations/all.txt'
```

#### For a range of connected dots ([Filtered lists](combinations/Range%20of%20connected%20dots/))

```bash
# Between 5 (inclusive) and 6 (inclusive) connected dots
$ grep -E '^.{5,6}$' 'combinations/all.txt'
```

#### For a specific dot being connected ([Filtered lists](combinations/Specific%20dot%20being%20connected/))

```bash
# Dot at position (8) being connected
$ grep -F '8' 'combinations/all.txt'
```

#### For multiple specific dots being connected

```bash
# Dots at positions (5) and (7) being connected
$ cat 'combinations/all.txt' | grep -F '5' | grep -F '7'
```

## License

```
Copyright (c) delight.im <info@delight.im>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
