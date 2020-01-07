A programmatic attempt at finding the optimal strategy for playing the dice game [Farkle](https://www.dicegamedepot.com/farkle-rules/).

Originally, my hope was to learn some insight that would help me when playing the game with friends. I built a number
of different simple algorithms which would determine which were the most efficient. Most Farkle players
tend to be fairly conservative, and I hoped that I might find that being more aggressive would lend me an advantage.

Instead, I found the opposite. Playing more aggressive, on aggregate, is the worse play. Instead, players should
take scores whenever possible, and pretty much never roll fewer than 2 dice. 

The following figures are determined over 10,000 rounds for each algorithm. As you can see, there's a very high amount
of variance present in each of the algorithms, and none of them have a mean time to 10K that would win most
games of Farkle against live opponents.

| Player Name | Mean Rounds to 10K | Median Rounds to 10K | Standard Deviation | Minimum Rounds to 10K | Maximum Rounds to 10K |
|-------------|--------------------|----------------------|-------------------|-----------------------|-----------------------
HoldOnOneHundred    |   28.82 |   29    |   4.18   |   15 |   50
HoldOnTwoHundred    |   26.36 |   26.5    |   4.14   |   14 |   45
HoldOnThreeHundred    |   28.26 |   28    |   5.96   |   13 |   58
HoldOnFourHundred    |   29.94 |   30    |   7.01   |   11 |   60
HoldOnFiveHundred    |   32.13 |   32.5    |   8.11   |   12 |   70
HoldOnFiveHundredUnlessSix    |   34.65 |   35    |   10.03   |   10 |   81
HoldOnSixHundred    |   37.92 |   39    |   11.27   |   11 |   97
HoldOnSevenHundred    |   47.92 |   49    |   16.23   |   11 |   132
HoldOnEightHundred    |   57.93 |   59    |   21.11   |   12 |   191
HoldOnNineHundred    |   60.95 |   62    |   22.15   |   14 |   162
HoldOnThousand    |   61.85 |   63    |   22.51   |   11 |   190
ThreeHundredRound    |   25.32 |   25    |   3.65   |   14 |   41
FiveHundredRound    |   28.88 |   29    |   5.99   |   14 |   57
SevenHundredRound    |   28.63 |   29    |   7.25   |   11 |   65
FifteenHundredRound    |   57.14 |   58    |   23.57   |   12 |   224
TwoThousandRound    |   104 |   108    |   52.47   |   11 |   480
HoldOnFive    |   28.13 |   28    |   4.88   |   13 |   48
HoldOnFour    |   25.59 |   26    |   4.24   |   11 |   43
HighestDiceFour    |   25.6 |   26    |   4.33   |   10 |   44
HoldOnThree    |   23.56 |   24    |   3.83   |   9 |   40
HoldOnTwo    |   23.48 |   24    |   4.3   |   9 |   42
HoldOnOne    |   29.36 |   30    |   6.9   |   9 |   59
FourIfFiveHundred    |   34.53 |   35    |   10.02   |   8 |   89
TwoIfFiveHundred    |   44.83 |   46    |   14.1   |   9 |   124
ThreeIfFiveHundred    |   34.71 |   35    |   10.03   |   9 |   91
TwoHundredRound    |   25.89 |   26    |   3.49   |   15 |   41
ThreeIfTwoHundred    |   23.47 |   24    |   3.89   |   11 |   39
TwoIfThreeHundred    |   23.53 |   24    |   4.44   |   10 |   44
FourIfSevenHundred    |   56.45 |   57    |   20.09   |   12 |   165
FiveIfNineHundred    |   76.21 |   78    |   28.97   |   15 |   225
DecreasinglyAggressive    |   28.24 |   28    |   6.41   |   12 |   61
IncreasinglyAggressive    |   30.08 |   30    |   6.93   |   12 |   66