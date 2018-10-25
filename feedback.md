# Assignment Two Feedback

## Group members: u6406312,u6079329,u6609337

## Tutor Comment

Good job guys. Your game looks really nice and it very 
clear and easy to use which is great. I'm a bit fan of 
the luxury relaxing aesthetics. Good use of commenting 
throughout, just be careful there were no authorship 
details, which was a requirement for this stage.

I had some issues with moving pieces and them getting 
stuck on the board, and invalid placements make the 
pieces disappear, but otherwise it ran quite well. The 
piece selector is really nice, I would maybe suggest it 
would also be nice to see the ones on the left and 
right, maybe in miniature, to help the user navigate 
through, but that's a small suggestion. It's also a 
little frustrating having to hold down the mouse button 
to rotate/flip pieces. The press and hold for hints is 
pretty cool.

Most of your code is quite clear and readable which 
is great. You should leave out any old code you have 
though, unless there's a really really good reason to 
keep it.

Presentation feedback:
Good idea to start with your features, taking a user-
experience view. Good speaking pace and style 
throughout. Great explanation of minimal subsets, good 
description of the benefits it brought you.

Always good to have a game demo.

## Mark

**  9.6/11.0**

## Miscellaneous marks

| Level | Requirement | Result |
|:-:|---|:-:|
||All files correct                     | .25/.25 |
||Authorship clear for all classes      | 0/.25 |
||Appropriate use of git                | .5/.5  |
||Program runs from jar                 | .25/.25 |
|P|Appropriate use of OO features       | .35/.5  |
|P|Presentation pdf complete            | .5/.5  |
|CR|Program well designed               | .5/.5  |
|CR|Comments clear and sufficient       | .5/.5  |
|CR|Coding style good                   | .5/.5  |
|CR|Appropriate use of JUnit tests      | .35/.5  |
|D|Design and code of very high quality | .25/.25 |
|D|Demonstrates interesting extensions  | .15/.25 |
|D|Works well and easy to run           | 0/.25 |
|HD|Game is exceptional                 | 0/.5  |

**Total for miscellaneous marks:**  4.1/5.5

## Game marks (manual)

| Level | Requirement | Result |
|:-:|---|:-:|
|CR|Pieces snap into place           | .25/.25 |
|CR|Pieces can be rotated            | .25/.25 |
|CR|Pieces can be flipped            | .25/.25 |
|CR|Only valid placements allowed    | .25/.25 |
|D |Basic starting placements        | .25/.25 |
|HD|Hints                            | .25/.25 |
|HD|Interesting starting placements  | .25/.25 |

**Total for manual marks:** 1.75/1.75

## Test results

| Task | Test | Result | Marks |
|:-:|---|:-:|:-:|
| |Compiled|.25/.25|.25|
|2|PlacementWellFormed|5/5|.5|
|3|PlacementStringWellFormed|5/5|.5|
|5|PlacementStringValid|5/5|.5|
|6|ViablePlacements|5/5|1|
|9|Solutions|5/5|1|

**Total for tests:** 3.75/3.75

## Originality statements

#### Originality statement G
We declare that the work we have submitted for Stage G of this assignment and all stages before it is entirely our own work, with the following documented exceptions:

Lachlan McVicar (u6406312):

Waldobot uses this code to fix an exception:
    try
    {
    Robot bot = new Robot();
    bot.mouseMove(50, 50);
    }
    catch (AWTException e)
    {
    e.printStackTrace();
    }
    this code is sourced from here:
    https://stackoverflow.com/questions/13785747/robot-class-unhandled-exception-type-awtexception

    All images are sourced externally belong to their respective oweners

Signed: James Frampton Reid (u6079329), Feier Xiao (u6609337), and Lachlan McVicar (u6406312)

#### Originality statement F
We declare that the work we have submitted for Stage F of this assignment and all stages before it is entirely our own work, with the following documented exceptions:

* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)

* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)

* ....
the arrow key image is taken from
https://www.101computing.net/wp/wp-content/uploads/arrowKeys-300x205.png

Signed: Signed: James Frampton Reid (u6079329), Feier Xiao (u6609337), and Lachlan McVicar (u6406312)
#### Originality statements E
I declare that the work I have submitted for Stage E of this assignment and all stages before it is entirely my own work, with the
following documented exceptions:

-Used similar structure to test files provided by the lecturer

Signed: James Frampton Reid (u6079329)I declare that the work I have submitted for Stage D of this assignment and all stages before it is entirely my own work, with the following documented exceptions:

// all problems that are outputted by the difficulty program are transcribed from IQ twist manual

Signed: Lachlan McVicar u6079329
I declare that the work I have submitted for Stage E of this assignment and all stages before it is entirely my own work, with the
following documented exceptions:

-Used similar structure to test files provided by the lecturer

Signed: Feier Xiao (u6609337)

#### Originality statements D
I declare that the work I have submitted for Stage D of this assignment and all stages before it is entirely my own work, with the following documented exceptions:

* The idea of <...> came from a discussion with <...>

* The code in class <...> uses an idea suggested by <...>

Signed: James Frampton Reid u6079329
I declare that the work I have submitted for Stage D of this assignment and all stages before it is entirely my own work, with the following documented exceptions:



Signed: Lachlan McVicar u6079329
I declare that the work I have submitted for Stage D of this assignment and all stages before it is entirely my own work, with the following documented exceptions:

Signed: Feier Xiao (u6609337)

#### Originality statement C
We declare that the work we have submitted for Stage C of this assignment and all stages before it is entirely our own work, with the following documented exceptions:

Task 2: the idea to use indexOf in this function came from https://stackoverflow.com/questions/506105/how-can-i-check-if-a-single-character-appears-in-a-string
Signed: James Frampton Reid (u6079329), Feier Xiao (u6609337), and Lachlan McVicar (u6406312)

#### Originality statement B
We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work, with the following documented exceptions:


Signed: James Frampton Reid (u6079329), Feier Xiao (u6609337), and Lachlan McVicar (u6406312)

## Git Log
```
commit ee4322fc316a3a1fb3d47c915fd7ea57415ac379
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 23:32:51 2018 +1100

    Few comments

commit 1ca37e47a03bc4dada6060856f36898efb0c9aa3
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 23:27:35 2018 +1100

    Clean meaningless system.out.println

commit 2e2f9dc523d4c8ef0d898b97fef31b3b44576305
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 23:21:58 2018 +1100

    admin

commit bd2175bdcc7ffd23f349c3786c6f41bc906fd09b
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 23:18:08 2018 +1100

    Latest version of game.jar

commit 912927aca4945e8dc05ad9d5d549b8ed6b4b8914
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 23:17:08 2018 +1100

    Signature for best code

commit a1c44197abe73539546f6c534fd641293bc3c033
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 23:16:05 2018 +1100

    little change on the instruction

commit de1a08f8a9ae2124ba31903d28b6f8235b9d0618
Merge: 0e0a3b6 99a0255
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 23:05:38 2018 +1100

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       admin/G-best-u6406312.md

commit 0e0a3b6d89481eef8cfcc3bf8246145c5dd4344e
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 23:05:22 2018 +1100

    admin files

commit 99a0255b39615a2030520f1e1acd68a6116f63b5
Merge: b55a8ea 4cf4c5f
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 23:02:40 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 4cf4c5faccce82d9a9221869903417d0403e4807
Merge: b8adeb0 2f40046
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 23:02:26 2018 +1100

    Little change for timer

commit b55a8ea8f26433fa561daeaa2b6f1890ffb78c5f
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 22:57:10 2018 +1100

    Admin

commit b8adeb0d125b2ab79f2f79621cc99d57b0ad1327
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 22:47:00 2018 +1100

    Revert test given by lecturer

commit 26ea0342b482913086cd9daabeb62889a2ccb884
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 22:44:26 2018 +1100

    Admin files

commit 2f4004607aaff1661b8f4e1312e56e51c8a996f5
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 22:40:26 2018 +1100

    best code

commit adab35426cac54e836d3d2429afbfb949efc21b0
Author: Lachlan Alexander McVicar <u6406312@anu.edu.au>
Date:   Thu Oct 18 22:27:49 2018 +1100

    this is probably the last one

commit 23e1f1befe96ff82e2aacd3d25d8286b88690206
Merge: 4d50707 c87836f
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 22:27:36 2018 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6406312/comp1110-ass2

commit 4d5070783182b1ffff64e45ff589801dcbb8dfd4
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 22:27:16 2018 +1100

    contribution

commit c87836fe220fba60e1249e22fc9fbd7c25d85720
Author: Lachlan Alexander McVicar <u6406312@anu.edu.au>
Date:   Thu Oct 18 22:24:32 2018 +1100

    Delete Presentation.pdf
    (it wasnt the real one)

commit 820f9d60350dd8731e148e1eb583f7222f5e8e8f
Author: Lachlan Alexander McVicar <u6406312@anu.edu.au>
Date:   Thu Oct 18 22:22:05 2018 +1100

    Presentation.pdf (the real one)

commit 81f2724c40bc65b08d7dd5bbcecfa9e0cacb2fe5
Author: Lachlan Alexander McVicar <u6406312@anu.edu.au>
Date:   Thu Oct 18 22:20:20 2018 +1100

    Delete COMP1110 - wed18i (1).pdf

commit e4b59d24d9826f05a69a29a6e6ecff2e138c05ec
Author: Lachlan Alexander McVicar <u6406312@anu.edu.au>
Date:   Thu Oct 18 22:19:44 2018 +1100

    Added PDF

commit 53d80355adb32bf6ed32d692710aad44d627170e
Merge: 035b784 1a243c4
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 22:18:37 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 035b784976516991f6ae89d9c04291c580e624ee
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 22:18:21 2018 +1100

    change to Board

commit 1a243c499c6b760bb7249ec8725683071530a576
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 22:12:32 2018 +1100

    Annotations

commit 8b2b01842d73e6a8647724b68d340d0edd136b61
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 22:03:48 2018 +1100

    G-Best

commit d2757469cadcc56c638f0dec5b6711d7207c0c97
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 21:22:27 2018 +1100

    Removed mouse hand :(

commit 50505ab1105796ab9f6ebf49f045c5ef9d2ab40f
Merge: 1802646 e7ad214
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 19:38:45 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 180264641f4e66c1baaa65fbb9e9868b34729cbb
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 19:30:20 2018 +1100

    text set to 16

commit e7ad2144a2b7580b9e2bb3a647e01bf2a1aa8481
Merge: 30ec1a3 d9565d6
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 19:11:09 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 30ec1a3db9c1d7fb91f92b963159df470a2618f9
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 19:10:59 2018 +1100

    change to Board

commit d9565d61e6b330bb1da53746b108947040fed3b8
Merge: 1412cc6 ffb9d75
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 19:05:22 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 1412cc65acb07f9f5659f45689dd69f37f4ee265
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 19:05:18 2018 +1100

    Little change for timer

commit 77e2d48485eab23fe6559a8d2d6de9950f3302ec
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 19:03:35 2018 +1100

    G- Feature

commit ffb9d75aa9a41cc768fa8b7daf28260bcff89ba8
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 18:36:11 2018 +1100

    Some UI p5

commit 61bbae9c7482ba18d7dca8dfbd1330a7d3c5c5ae
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 18:06:57 2018 +1100

    Timer fixes

commit abb0a44d701ac16499dc7da7eea4463ab7b25b89
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 17:49:38 2018 +1100

    Add ID to authorship

commit fac54511a4d8e307473318350b312e0cbd196203
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 17:46:57 2018 +1100

    change to Board

commit e17931978f179cb7f11d545042c748f6f2be60ac
Merge: 6eadd8b 2c00f0b
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 17:43:49 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 6eadd8bbea2715367094f12e319a8f88b9df90c0
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 17:43:36 2018 +1100

    change to Board

commit 2c00f0bc053e84ae435b27d95cf59a0675710c3d
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 17:42:20 2018 +1100

    Comments

commit efa27f358f3b66024c3bd361b7ba0840f2832ead
Merge: 7264dee 8a87b80
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 17:32:02 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 7264deebc30b7eca7a33c95e55b6a418cdf5b06c
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 17:31:47 2018 +1100

    Authorship

commit 8a87b809b58370dcade4bcb97519574eaec0233f
Merge: 5a33637 2bff208
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 16:54:02 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 5a33637e649dbdd64ff8528dea31c7b4c9281104
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 16:53:55 2018 +1100

    Timer

commit 2bff2089406a4d94e4a0d5e4fd31cf1dc429c665
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 16:43:24 2018 +1100

    fix getHint

commit 63c1b9fc6225950569394d590a9c8060aea406c8
Merge: 526230d 442a0ec
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 16:13:46 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 526230d567826cb3dacb4d61fef98edecac74f03
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 16:13:35 2018 +1100

    More User Interface 3

commit 442a0ec08d5d5ca13f48436485cc596e0f1afdf3
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 15:28:20 2018 +1100

    change to Board

commit 8164626cd8f8fe52054c61f1a119ba1abe728d23
Merge: 8ebd23b fa67a9c
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 14:49:15 2018 +1100

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/gui/Board.java

commit 8ebd23b80b4d06f2634508e500fae1ea146fb234
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 14:44:51 2018 +1100

    More User Interface 2

commit fa67a9c55ed2d4d04817526b8bfa82a837eb1ede
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 14:39:44 2018 +1100

    added messages

commit 21c1118129a73b6bba260975633e2d8e3daff608
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 14:34:50 2018 +1100

    change to Board

commit 865e99ecc23c6bdff230bf8a8fbd79b567869928
Merge: 41a7de2 751986c
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 14:26:36 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 41a7de2899b8b679736046a4735f3f01781a6dd0
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 14:26:30 2018 +1100

    change to Board

commit 751986c33a09a29573b562fbee9f97898c7d79c2
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 14:22:19 2018 +1100

    More User Interface

commit 1bb87ce0810ff32656bc5c4a9fb0474d11de6ce4
Merge: c92f594 69daa94
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 12:22:37 2018 +1100

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/Objective.java

commit c92f594c5031cf0b35c4b4713449a022591eaf9a
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 12:21:28 2018 +1100

    getHint function and the path

commit 69daa94f4a9dbf3decb8602edd2a794a81f4c2bb
Merge: 04dd6f4 ba00564
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 11:57:55 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 04dd6f4cfa9dc30107fb5c4467b0491bac1662a3
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 11:57:49 2018 +1100

    changes to Read Objectives, should work on more machines

commit ba005645e95332b33755aa2fac694fed6f0f2889
Merge: 9d7b2df 435d08b
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 11:44:37 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 9d7b2dffd56c5ff02f46fe7d84c25e391ff3cd56
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 11:44:23 2018 +1100

    Changes to victory and Instructions

commit 435d08baf78fdd6a60b61c79af0cb893e1a45a95
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 11:43:12 2018 +1100

    change to Board

commit 11ce80ae1c5f4b4ff5f2436d2d7895bbb8b94320
Merge: 746ada1 bb66f9b
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 11:40:16 2018 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6406312/comp1110-ass2

commit bb66f9b454e9857754b6cd8b0661b84fecf384f8
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 11:39:38 2018 +1100

    getHint

commit 746ada1b06f962c036c59149ac073b9e73bf3530
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 11:26:32 2018 +1100

    changes to resetPiece

commit e4ad0ceb0a56de69252edb304338d5fe0b9a1ce0
Merge: f4d57e6 28d1ae4
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 11:23:37 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit f4d57e64751f22600c25eab894e487662a959780
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 11:23:06 2018 +1100

    Fix little bug for getPieceSituation

commit 28d1ae4293e5b7adba61e4d46fb4aa6cf8d7fe23
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 11:23:05 2018 +1100

    changes to getHint

commit b2fff46cfaf8e4466aa4a99d28b4ab1e78f3bfd1
Merge: 145faac f5b4832
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 11:04:34 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 145faac275ac1fce12598b7ca382a2bf842b8269
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 11:04:25 2018 +1100

    csv

commit f5b483236444068124a13b5a5b514db2060d9249
Merge: 6bbe8e4 752ceff
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 11:02:37 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 6bbe8e4489571a7b1c776f7c5093f664c10aa8b2
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 11:02:13 2018 +1100

    getPieceSituationTest

commit 752ceffe2437156309c454dbf279c750a0fd6b47
Merge: ca69dac 048ffa2
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 10:44:21 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit ca69dac604d40a73b70065440b77f2da80732f2d
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 18 10:44:16 2018 +1100

    hints added

commit 048ffa2b769a7d824d73b9281646d1ba18d72d88
Merge: 1e7f901 116bb75
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 10:40:39 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 1e7f901f6a2df99bbc80ad7f5e9944169e0b5111
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 10:40:28 2018 +1100

    difficulty

commit 116bb755c85fc04e1b72d955fc77af6560a279c2
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 10:31:31 2018 +1100

    little change with the timer

commit 9a42e54282f89d7306ade4411756a1a6ab580f92
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 10:19:16 2018 +1100

    Delete some trash and make few comments

commit 0b5fd91b33d7d298a21447227b8f3df1df13cf84
Merge: 687229f 403b83c
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 10:13:54 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 687229f430ab18cbea0d8c6193984d9fcf8a43de
Author: u6406312 <u6406312@anu.edu.au>
Date:   Thu Oct 18 10:13:39 2018 +1100

    Viewer changes

commit 403b83ca5e107df4de832f8343899d9fc02fe13a
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 10:11:23 2018 +1100

    Tests

commit 9bab505307bc8977cd397b30da175f3baf64edd8
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 18 00:06:43 2018 +1100

    BoardSituationTest

commit c5870da32dab27dbe2fdf3ece816112271ddd459
Merge: c236ca9 3ffe994
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Oct 17 23:38:40 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit c236ca969b34739e7430e8b32566752a4bfdb247
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Oct 17 23:38:32 2018 +1100

    Tests

commit 3ffe9947f45845684381d56dcb566b9441c0c3f4
Author: u6406312 <u6406312@anu.edu.au>
Date:   Wed Oct 17 23:04:21 2018 +1100

    WaldoTest - fixed

commit a6fe30f5b237e5f42d4610a9322cc63d8629130d
Author: James <u6079329@anu.edu.au>
Date:   Wed Oct 17 12:11:35 2018 +1100

    csv files

commit 5b65ce7d98b91c558dbf1724b7ac2e7a90df64f5
Author: u6406312 <u6406312@anu.edu.au>
Date:   Wed Oct 17 10:52:01 2018 +1100

    WaldoTest - annotations

commit a3242cec1b00a6eb43a0974ff7daa409d0629a81
Author: u6406312 <u6406312@anu.edu.au>
Date:   Wed Oct 17 10:38:35 2018 +1100

    WaldoTest

commit b18ac8a91385b4782af27f92d287836eee8a96da
Merge: 9597027 4b50a5a
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Oct 16 21:03:27 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 9597027ce775ef48166e523544035387022e5b47
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Oct 16 21:03:17 2018 +1100

    Moved elements to new popup box

commit 4b50a5aab4d8d9fc45cba00980a84c0c3076339b
Merge: caf26aa 5bb1704
Author: James <u6079329@anu.edu.au>
Date:   Tue Oct 16 19:20:27 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit caf26aa0fa541bd265231ed43bc31dff9130b0f2
Author: James <u6079329@anu.edu.au>
Date:   Tue Oct 16 19:20:16 2018 +1100

    changed pieces to work with the piece selector

commit 5bb170431f4737bdb0ee74378ecc3fcb9158fd91
Merge: 4b4a947 da2b61d
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Oct 16 16:31:09 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 4b4a947a61455ab615135693be98eb1306fe75a2
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Oct 16 16:31:01 2018 +1100

    Few comments and organize the project

commit da2b61d31df73e60e5f7fd44617e84cb4a130c24
Merge: a0f434b 2c6cf63
Author: James <u6079329@anu.edu.au>
Date:   Tue Oct 16 16:15:54 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit a0f434b5f61f66abf2253897e7ef9cb0b868f291
Author: James <u6079329@anu.edu.au>
Date:   Tue Oct 16 16:15:46 2018 +1100

    csv files

commit 2c6cf6343688ceb5c5607bd42c2da2aca0582b53
Merge: b762597 a77d510
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Oct 16 14:35:21 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit b7625976f24085af243339436326705c3df77557
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Oct 16 14:35:09 2018 +1100

    Merge attempt 4;
    plz keep waldo

commit e8b9ad862d55a4d6eea9ccd508bb4540787284d0
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Oct 16 14:33:53 2018 +1100

    Merge attempt 4;
    plz keep waldo

commit 1e2b9e9ba55cc240360642be6dad5d791b7b617e
Merge: a77d510 dc7c6af
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Oct 16 10:15:04 2018 +1100

    Merge branch 'master' of http://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit a77d5108a73c4807a208f80ba90a15616d334684
Merge: cc8dccb f24a761
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Oct 16 10:12:47 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit cc8dccbb42d52250b1053723d617443e19a8cb50
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Oct 16 10:12:41 2018 +1100

    Deleted trash

commit f24a76157d654bd3b3db1d6f47eb422f6cab3f54
Merge: ac94012 acfa8b0
Author: James <u6079329@anu.edu.au>
Date:   Mon Oct 15 17:16:59 2018 +1100

    Merge remote-tracking branch 'origin/master'
    
    Conflicts:
            game.jar
            src/comp1110/ass2/gui/Board.java

commit ac940123f8a731fde1d5e47dd1f97ab614da605d
Author: James <u6079329@anu.edu.au>
Date:   Mon Oct 15 17:12:01 2018 +1100

    csv files

commit acfa8b015425e080653b9c031ee61eaa6a9c976e
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Oct 15 16:52:10 2018 +1100

    Timer Completed.2.3 merged3

commit 74763e6e52f700cddbd2111ca28963dd879aa3b8
Merge: 09b7d1e 5f4fdab
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Oct 15 16:49:12 2018 +1100

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/gui/Board.java

commit 09b7d1e1d357243571964b8b08cd8774f91a4f5e
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Oct 15 16:46:03 2018 +1100

    Timer Completed.2.3 merged2

commit 5f4fdab27e8eebbca282d382a58d478a7238dabd
Merge: 2575530 0fa56cc
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Oct 15 16:44:47 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 25755301ab586f096d45438f30e86ceaa09d38c4
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Oct 15 16:44:38 2018 +1100

    Timer Completed.2.3 merged

commit 0fa56cc6601e904cf6bf83d8853ab8c591f16ab5
Merge: e907c50 2fb0a56
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Oct 15 15:56:35 2018 +1100

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar
    #       src/comp1110/ass2/gui/Board.java

commit e907c5035d5771a34c9d24068d682040ad9f1b24
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Oct 15 15:55:16 2018 +1100

    Timer Completed.2.2

commit 2fb0a5628f87e8383f247962cb2fcfa61d1392e9
Author: James <u6079329@anu.edu.au>
Date:   Mon Oct 15 14:29:58 2018 +1100

    csv files

commit cb181939e9e051e6dd673452633d234db9bef3fd
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Oct 15 13:38:25 2018 +1100

    Timer Completed.2

commit 82ede7ca7e19442bc6325888823bff8e4f4a9f2e
Merge: 7cb2d0e 86283cb
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Oct 15 13:37:20 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit 7cb2d0e906e9469e10eaf959cd33a7b8788afde7
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Oct 15 13:37:09 2018 +1100

    Timer Completed

commit 86283cb64a5495e7437f122446da9f3c3ae38cd5
Merge: d12608b da5e537
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Oct 15 13:06:52 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit d12608b34abdbb908be4a7935466e5f9cb9d1b4e
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Oct 15 13:06:41 2018 +1100

    some timer attempts

commit da5e5371787dc3ea6fe06243108f79bd8d18fafe
Author: James <u6079329@anu.edu.au>
Date:   Sat Oct 13 14:37:36 2018 +1100

    csv files

commit 6dea3037e6a5506fdc149ab27bfb3994879c91e2
Merge: 409f375 b1d3309
Author: James <u6079329@anu.edu.au>
Date:   Sat Oct 13 14:36:15 2018 +1100

    Merge remote-tracking branch 'origin/master'
    
    Conflicts:
            src/comp1110/ass2/gui/Board.java

commit 409f375a204969a5add74a48e8e6a9a3b34c030d
Author: James <u6079329@anu.edu.au>
Date:   Sat Oct 13 14:27:33 2018 +1100

    csv files

commit b1d33097263a81ed93241739b47f6d43aac3a812
Merge: 940b97c cc985d0
Author: u6406312 <u6406312@anu.edu.au>
Date:   Sat Oct 13 11:43:13 2018 +1100

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/gui/Board.java

commit 940b97cdf15b08de2188be27c2e4cf7fefd24d3b
Author: u6406312 <u6406312@anu.edu.au>
Date:   Sat Oct 13 11:40:10 2018 +1100

    Waldo improvements

commit dc7c6afd3d03055f27d92a60b30357601816d4cb
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Thu Oct 11 22:18:22 2018 +1100

    Correct feature list for G

commit cc985d0d8d72872e59d5b68e59d5bf4f2c4c2ac2
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 11 12:15:30 2018 +1100

    csv files

commit 631fb6d8f88b935b561fdfcaf526ffe1984fd79f
Author: James <u6079329@anu.edu.au>
Date:   Wed Oct 10 21:01:06 2018 +1100

    csv files

commit 306c90b78e4f4f474c370e8591721d0294ed19e3
Author: James <u6079329@anu.edu.au>
Date:   Wed Oct 10 21:00:47 2018 +1100

    csv files

commit a1bd698c952b9f109d6ac344a1d0b0e33c24ea42
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Oct 9 17:14:29 2018 +1100

    Test.java

commit 45eda6e22633b8c492a9642d75e47a070d31f070
Merge: 1fa40ac c302dd2
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Oct 9 14:33:22 2018 +1100

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar
    #       src/comp1110/ass2/gui/Board.java

commit 1fa40ac642753b75bb951be6268dbb737e2aa171
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Oct 9 14:32:56 2018 +1100

    Instructiona;

commit 8f07894e49166c5a801396ccf3cef3c34df36958
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Oct 9 14:26:52 2018 +1100

    pickingUp and Snapping

commit c302dd26032536a458734e116f72f4b2b9eae2c1
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sun Oct 7 10:50:33 2018 +1100

    debug on getDictionary

commit 48ddb360de8268fdaa061e5b9ba6793b1e3ef1a6
Merge: f49dc07 1b9e8fc
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sun Oct 7 09:03:20 2018 +1100

    Merge remote-tracking branch 'origin/master'

commit f49dc0733721c7af16360d23dbf78379270640fa
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sun Oct 7 09:03:00 2018 +1100

    code format for UI file and the getDictionary

commit 1b9e8fc7c6e6dca37eda9c51aceb3f08c1de2532
Author: James <u6079329@anu.edu.au>
Date:   Sat Oct 6 17:18:47 2018 +1000

    changes

commit 6162b1ba3c9b3f18c55787429ac561d21479be09
Merge: 4c8a352 64357b1
Author: James <u6079329@anu.edu.au>
Date:   Sat Oct 6 17:18:07 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit 4c8a352a5f41eeb4dd2521b5d1f6d8edde2ce066
Author: James <u6079329@anu.edu.au>
Date:   Sat Oct 6 17:17:45 2018 +1000

    commit

commit 64357b1da268f17bd679ccef235fe26f49555650
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sat Oct 6 16:23:48 2018 +1000

    Optimization on getDictionary

commit ea25ef0d9bcd8a0961918e341dfb28079d2244d3
Author: James <u6079329@anu.edu.au>
Date:   Sat Oct 6 15:14:41 2018 +1000

    csv files

commit b9d8ee90b3ebb8c0e8d6e048263dbb71a120112c
Author: James <u6079329@anu.edu.au>
Date:   Sat Oct 6 14:48:22 2018 +1000

    comments

commit 9dfe6f227b5311492eb060a8484dc327e58195d3
Author: James <u6079329@anu.edu.au>
Date:   Sat Oct 6 14:31:33 2018 +1000

    csv files

commit 2f118fd27e1d19997403c0355a089247a8c6ca91
Merge: a8c9bf2 9b1cc81
Author: James <u6079329@anu.edu.au>
Date:   Sat Oct 6 14:31:03 2018 +1000

    Merge remote-tracking branch 'origin/master'
    
    Conflicts:
            src/comp1110/ass2/TwistGame.java

commit a8c9bf294edc70759f300adb3dadafceeae6c021
Author: James <u6079329@anu.edu.au>
Date:   Sat Oct 6 14:16:49 2018 +1000

    csv files

commit 9b1cc81d2a7900d6ca78f992006093de3b0cddaa
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sat Oct 6 08:49:54 2018 +1000

    Finished read and write for csv

commit 170140c1418d6849505c958cdf0dfcc98e56c118
Merge: fe40147 6b862e3
Author: James <u6079329@anu.edu.au>
Date:   Fri Oct 5 16:55:22 2018 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6406312/comp1110-ass2

commit 6b862e302bedc2c91ea0f193257cedb4190f493d
Author: u6609337 <u6609337@anu.edu.au>
Date:   Fri Oct 5 15:00:03 2018 +1000

    Debug on getDictionary

commit fe40147a9d24880eff0eb731fbd8f1cc5a9d99a8
Merge: a38f600 91e7aae
Author: James <u6079329@anu.edu.au>
Date:   Fri Oct 5 11:20:22 2018 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6406312/comp1110-ass2

commit 91e7aae45e642f0ad87193a4e876670de50ca3c2
Author: u6609337 <u6609337@anu.edu.au>
Date:   Fri Oct 5 11:07:00 2018 +1000

    Some comments

commit 4f18f2f2268bca1e0c1eb4a58c35e196db1d9f24
Author: u6609337 <u6609337@anu.edu.au>
Date:   Fri Oct 5 10:54:23 2018 +1000

    Debug for getDictionary

commit 1f5f22b77a4b1e7950dcc0431559bf7b62356e10
Merge: b6f8ebb e0a2dd8
Author: u6609337 <u6609337@anu.edu.au>
Date:   Fri Oct 5 10:13:33 2018 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar

commit b6f8ebb295ceca1c15b994ca507eb616aa098e4c
Author: u6609337 <u6609337@anu.edu.au>
Date:   Fri Oct 5 10:10:52 2018 +1000

    try on getDictionary

commit a38f600d93adb7d372a0836f4a5d512f0c1291d8
Merge: 723c9b4 e0a2dd8
Author: James <u6079329@anu.edu.au>
Date:   Fri Oct 5 09:44:26 2018 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6406312/comp1110-ass2

commit 723c9b4728cbb4281fc10463d41c1dbfd5c32be2
Author: James <u6079329@anu.edu.au>
Date:   Fri Oct 5 09:41:07 2018 +1000

    csv files

commit e0a2dd8c42f7b062dc550a116153f01cc09966e3
Merge: 5c43ac8 c62b72a
Author: u6406312 <u6406312@anu.edu.au>
Date:   Fri Oct 5 09:40:22 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit 5c43ac821d34c9280dd8c041da026931fbcd2ffa
Author: u6406312 <u6406312@anu.edu.au>
Date:   Fri Oct 5 09:40:11 2018 +1000

    pickingUp and Snapping

commit c62b72ae7e080dbde4e57762526d099bc421d288
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 4 21:31:19 2018 +1000

    csv files

commit 2c4f450d2e0fabb658bb31b6fdd0f8088b946b66
Author: James <u6079329@anu.edu.au>
Date:   Thu Oct 4 20:29:02 2018 +1000

    added to Piece

commit c896509545fa40ac1ecc92804ed8475a5818a02c
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 4 10:33:35 2018 +1000

    Debug about findInsertPosition

commit 482f3930add857c860ce1cf1123737b25b1256a4
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Oct 4 10:11:46 2018 +1000

    game.jar

commit 57b28eecc7c0c26dcad9070b726fb5168e818cf0
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Wed Oct 3 18:11:19 2018 +1000

    .md update

commit a6795aa75415ce275821b840c9e87db6db7ed16e
Merge: 5080bab c93d721
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Wed Oct 3 18:07:52 2018 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/gui/Board.java

commit c93d721a2d4db2fcc538ec9fe4bdc43c01819538
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Oct 3 18:07:42 2018 +1000

    Review

commit 5080bab3a59706884b52df75fbd725c63850acaf
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Wed Oct 3 18:07:08 2018 +1000

    quick edit 2

commit be3d31a00f75de782bc15ed8e8d428c70498d657
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Oct 3 17:01:26 2018 +1000

    Reviews

commit bd12994e5a205306b99e1d0214894d0865b40d34
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Oct 3 15:34:32 2018 +1000

    FIXME TASK2

commit 63487bc8b41d941f15bf1d43fee57916557600ff
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Oct 3 15:32:32 2018 +1000

    Revoke change on task 2

commit 7abc0196df7634bbeb190788c72965e5f1a33b82
Merge: b22a152 8f5d442
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Oct 3 15:29:29 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit b22a1526391c6173f81bcf6eafc95503fa487784
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Oct 3 15:29:23 2018 +1000

    Dealt with no pegs placement, still had some bugs

commit 8f5d442aff661a0f06e2bf6058659a0661c737ea
Author: u6406312 <u6406312@anu.edu.au>
Date:   Wed Oct 3 14:55:50 2018 +1000

    F review

commit 44010600cf3450ae38969c3cdf393834bd15dba1
Author: u6406312 <u6406312@anu.edu.au>
Date:   Wed Oct 3 14:53:46 2018 +1000

    Selection progress

commit b934c8d0bcf8dd7f51c09f76c4707bbf7c0ddd67
Author: James <u6079329@anu.edu.au>
Date:   Tue Oct 2 18:32:31 2018 +1000

    added to Piece

commit adabc570eeb0436b4ceffb4cea8e9f4f1652edc3
Author: James <u6079329@anu.edu.au>
Date:   Tue Oct 2 17:50:33 2018 +1000

    comments

commit 45113d2580927b00ecb1fec332b4a9662619fc86
Merge: 85b46c5 8b40fd0
Author: James <u6079329@anu.edu.au>
Date:   Tue Oct 2 17:26:03 2018 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6406312/comp1110-ass2

commit 85b46c57d20db68488cf1fa4790f2ab8474a2228
Author: James <u6079329@anu.edu.au>
Date:   Tue Oct 2 16:38:10 2018 +1000

    added to Piece

commit 8b40fd0ae3f899d40a1171c1f30bf7bb4f0ea99f
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Oct 2 16:09:46 2018 +1000

    Little

commit 114d58cb13967437487bb270c03484b4cad72463
Merge: 970c164 5f0575a
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Oct 2 16:07:53 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit 970c164033952732a85242bf670def36fb2f381f
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Oct 2 16:07:49 2018 +1000

    Comments

commit 5f0575a0045ffdd302ee3de3e6617a93747c4459
Merge: ae9a1cc d31b6f5
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Oct 2 16:06:36 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit ae9a1ccee268f0ac870930567abf769f8c5df78c
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Oct 2 16:06:23 2018 +1000

    Selection progress

commit d31b6f5ec8193fd49a2fcfd7d1536f6c33ce3f03
Author: James <u6079329@anu.edu.au>
Date:   Tue Oct 2 15:59:44 2018 +1000

    added to Piece

commit c2eb90fa6597ab84d70a1b363a74e1c44b69161d
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Oct 2 15:58:47 2018 +1000

    Originality and contribution

commit 57876db9b3828b884d90968436b18d7e0a57e0de
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Oct 2 15:54:25 2018 +1000

    game.jar

commit b5c3332d6da1ffba14909876481891f524ec957c
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Oct 2 15:23:57 2018 +1000

    Reduce redundant import

commit 72a4216f38d5d4765676aaf5fc2699ab337ca49d
Author: James <u6079329@anu.edu.au>
Date:   Tue Oct 2 10:16:50 2018 +1000

    added to Piece

commit ba7c7a7ff6d6817bfc0918b844ece8a95d6381b9
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sun Sep 30 20:59:21 2018 +1000

    Further optimization on the edge for piece

commit 30b63ef8069e5e0a864f3cbca3389e8e3c3836a1
Author: James <u6079329@anu.edu.au>
Date:   Sun Sep 30 14:07:58 2018 +1000

    added to Piece

commit fc5612d654162b979bf7bd6401b89d6acf55fc69
Merge: b5d2d84 f522c8b
Author: u6406312 <u6406312@anu.edu.au>
Date:   Sat Sep 29 12:04:35 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit b5d2d84292dc28f1898cc5b751a3055146d754b5
Author: u6406312 <u6406312@anu.edu.au>
Date:   Sat Sep 29 12:04:25 2018 +1000

    Selection progress

commit f522c8b897d842536183dd611ca0a925dfab4bd4
Merge: cb3a1c9 2f3ccdb
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sat Sep 29 11:53:43 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit cb3a1c95570fb7a6b5dcfd8ddba2544cfdca5782
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sat Sep 29 11:53:37 2018 +1000

    Further optimization

commit 2f3ccdbefdee8abfc73e099b6fc97c9b4dc6bc0b
Author: u6406312 <u6406312@anu.edu.au>
Date:   Sat Sep 29 11:46:01 2018 +1000

    Selection progress

commit 5e66801f439904c133a76c1ba7b7b259e16203bc
Merge: 8512000 03b9cea
Author: u6406312 <u6406312@anu.edu.au>
Date:   Sat Sep 29 10:55:16 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit 8512000ed144cf562c0a1d1e5b4161a7000eae4e
Author: u6406312 <u6406312@anu.edu.au>
Date:   Sat Sep 29 10:55:02 2018 +1000

    Basic Tutorial

commit 03b9cea89d3c3f2e5808a782ca13421c2dde3f15
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sat Sep 29 10:51:13 2018 +1000

    little change on structure

commit b751f8b04303f7499a70278d9a239e6e208ce5ca
Author: u6609337 <u6609337@anu.edu.au>
Date:   Fri Sep 28 17:10:53 2018 +1000

    Try on get solutions for only one piece

commit 12aafbdda3ac2c9b6faf082aba98221a1c9304e1
Author: u6609337 <u6609337@anu.edu.au>
Date:   Fri Sep 28 17:09:35 2018 +1000

    Try to get solution for only pegs

commit ee015ba98214f8bc37fbba29270ed94d7bf5b4bf
Author: u6609337 <u6609337@anu.edu.au>
Date:   Fri Sep 28 17:05:01 2018 +1000

    fix the bug

commit f10fd0eeeb4a5c59882c1fa18003e31ffc3107ea
Author: James <u6079329@anu.edu.au>
Date:   Fri Sep 28 16:45:15 2018 +1000

    added to Piece

commit 1597c4e24369146b76fa0e3f3f4d1ecef91519fd
Merge: a7b7312 16ca829
Author: James <u6079329@anu.edu.au>
Date:   Fri Sep 28 16:11:52 2018 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6406312/comp1110-ass2

commit a7b7312a86d14b03c38b884313481893fc9d060d
Author: James <u6079329@anu.edu.au>
Date:   Fri Sep 28 16:10:57 2018 +1000

    out of bound error fixed

commit 16ca829f7a4ed849b3374db2a4325a3eed9eed74
Author: u6406312 <u6406312@anu.edu.au>
Date:   Fri Sep 28 15:55:27 2018 +1000

    Basic Tutorial

commit 0301a278685da951f5d6092253d4e272426196ca
Author: u6406312 <u6406312@anu.edu.au>
Date:   Fri Sep 28 15:38:55 2018 +1000

    Now Alphebetised the difficulties

commit f88324efc4da057dac869e42655b060e0d03a07d
Author: James <u6079329@anu.edu.au>
Date:   Fri Sep 28 15:17:18 2018 +1000

    debugged code

commit d5f945747e32d043e256af936f9f40b6dc09d20a
Author: u6609337 <u6609337@anu.edu.au>
Date:   Fri Sep 28 13:36:36 2018 +1000

    delete some comments

commit 9096cd5f38bfd3d5438d481ebb759bbed017b322
Author: u6609337 <u6609337@anu.edu.au>
Date:   Fri Sep 28 13:35:45 2018 +1000

    Try to implement the get piece situation function but failed

commit 680e6226faf787b972a1b6eeb38eb1f23ce81220
Author: u6609337 <u6609337@anu.edu.au>
Date:   Fri Sep 28 13:21:45 2018 +1000

    Need help

commit ecad52d13cfccf9e7d0f095de8251d7b69ade4d8
Author: James <u6079329@anu.edu.au>
Date:   Fri Sep 28 12:32:07 2018 +1000

    fixed h piece

commit 93bc4940077bf75dbd91f15bef550f0c92596ddf
Author: James <u6079329@anu.edu.au>
Date:   Fri Sep 28 12:02:08 2018 +1000

    added to Piece

commit 629809161e12d8354c2648f0b42fa70aefbb2f65
Author: James <u6079329@anu.edu.au>
Date:   Fri Sep 28 12:01:28 2018 +1000

    added situation

commit dda70717dace25c6475cbe1ee42b520a278cfebd
Author: u6406312 <u6406312@anu.edu.au>
Date:   Fri Sep 28 10:19:52 2018 +1000

    [MORE UI].1.2

commit 79100644a541440024d2197db3e1b222fbc7af57
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Sep 27 20:07:59 2018 +1000

    Optimization for the viablePiece

commit ac8f459a6a0e05c7b97fb5848d816c5272a1f60e
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Sep 27 19:58:36 2018 +1000

    Few changes

commit 57bf9d496c38fe3219af80ec74a58bbf0a8f67d6
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Sep 27 19:49:52 2018 +1000

    Delete redundant code

commit 2d5243325ed96118a2a12102671d9dd968d5288f
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Sep 27 19:47:52 2018 +1000

    little change

commit bcf06aa5f772669d54bd745d9fb378dfdbb69163
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Sep 27 19:46:26 2018 +1000

    Little optimization on getViablePiece

commit 846968acbc62e0ce0c79a96d0d936bc3302f74dc
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Sep 27 19:16:53 2018 +1000

    Little change

commit 209941145f86f89a6f591511a1e9cfa2c7325fd6
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Sep 27 19:13:56 2018 +1000

    Little change on function structure

commit e2791c7355d457ad6835c3ef2762eb9390d55322
Merge: 36464b3 8e95798
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Sep 27 18:54:18 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit 36464b32ba315100d8f0ba8e4627e827bae580d5
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Sep 27 18:54:11 2018 +1000

    Little optimization

commit 8e95798035b73810d495f03a10fe9cc0b3e9917f
Author: James <u6079329@anu.edu.au>
Date:   Thu Sep 27 18:25:49 2018 +1000

    Changed controls

commit 6cad817d3d145773ac20d20f21bcee4a63276019
Author: James <u6079329@anu.edu.au>
Date:   Thu Sep 27 18:21:43 2018 +1000

    Changed controls

commit 826c96ac68aa70b4fb505037db09c6f44ed6d9bb
Author: James <u6079329@anu.edu.au>
Date:   Thu Sep 27 11:25:48 2018 +1000

    Changed controls

commit f118b14378299d0957570059751134d6436b66be
Merge: 21a5727 cb62c41
Author: James <u6079329@anu.edu.au>
Date:   Thu Sep 27 11:24:24 2018 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6406312/comp1110-ass2

commit 21a5727104ea034b5cc6d7b9da30c99aa34eac43
Author: James <u6079329@anu.edu.au>
Date:   Thu Sep 27 11:24:11 2018 +1000

    Changed controls

commit cb62c4125aa2d8f4a9948787298f560e8000528c
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Sep 26 22:42:29 2018 +1000

    Fix little bug for get hint

commit bc3d03cbbd6a8161a1972a6ee5857dbb680bf239
Merge: 77de12b d6c43c9
Author: James <u6079329@anu.edu.au>
Date:   Wed Sep 26 22:34:45 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit 77de12b452e6fb39f1f2a18750441c12972e0505
Author: James <u6079329@anu.edu.au>
Date:   Wed Sep 26 22:33:47 2018 +1000

    comment

commit d6c43c9b57ffb5cd182615ab99420ad037de70d7
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Sep 26 22:06:28 2018 +1000

    Try on task 11

commit 62f2c922be0c91749a5aae01262e1e49e8f93a12
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Wed Sep 26 18:13:44 2018 +1000

    quick edit 2

commit ad9708e3b53f1260085a0f7c3fa5e72067ff4918
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Wed Sep 26 18:12:40 2018 +1000

    quick edit

commit df1eed782e51c47fa458de784aa56ea9b2c7ce08
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Sep 26 11:25:16 2018 +1000

    Originality

commit 7a3b5fcf5758d45dab9691b1a1269bb6703659b4
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Sep 26 11:24:18 2018 +1000

    Finished test for getHint method and few little changes of files

commit 03b2a4d4573685239622eef0d91259e69a83acde
Author: James <u6079329@anu.edu.au>
Date:   Tue Sep 25 12:10:27 2018 +1000

    Assertion

commit c832a22e4ea094375b6f7df80713a701f3ceec30
Merge: c825c12 fbbfaa3
Author: James <u6079329@anu.edu.au>
Date:   Tue Sep 25 12:08:14 2018 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6406312/comp1110-ass2

commit c825c127052b2d1e2d011a810704fc94afd61647
Author: James <u6079329@anu.edu.au>
Date:   Tue Sep 25 12:07:55 2018 +1000

    Set Orientation test

commit fbbfaa3777b750051941cd990c07006cde4bbdce
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Sep 24 17:47:20 2018 +1000

    [MORE UI].1.1

commit f5a98cb0b122dcff7582510f45e8de684268d95b
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Sep 24 17:36:53 2018 +1000

    MORE UI

commit d449c6f5d5ee8d028444bc4f93438d4a9f9ef4fd
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Sep 24 16:09:39 2018 +1000

    Task 8.6.4
    tests Finished

commit 74c2499d7c0621a50cfa410a05cc054048537210
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Sep 24 15:34:11 2018 +1000

    Task 8.6.3 -> now using pegPlacement
    tests Finished

commit 50160ed1cbd6715636797de132031aa2e98c85a0
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Sep 24 15:32:11 2018 +1000

    Task 8.6.2 -> now using pegPlacement
    tests Finished

commit 975263c0c052914e22ebe05ba21673023be47068
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Sep 24 15:29:58 2018 +1000

    Task 8.6.1
    tests Finished

commit 753ffa1415108dfcdd0385fad9b56667ff40e5db
Merge: 801df21 61e95ba
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Sep 24 14:49:28 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit 801df210f7525453fa6c39b51968d2d920ea2787
Author: u6406312 <u6406312@anu.edu.au>
Date:   Mon Sep 24 14:49:16 2018 +1000

    Task 8.1
    tests.1

commit 61e95baf5f1953076e25ff6e552bc2f296921a4a
Author: James <u6079329@anu.edu.au>
Date:   Mon Sep 24 12:39:16 2018 +1000

    Set Orientation test

commit e8c0302c7e09f9e7e3a9b3cb1375b7bd0e0b1764
Author: James <u6079329@anu.edu.au>
Date:   Sun Sep 23 18:12:46 2018 +1000

    originality

commit 931387920d827ea0ef9e81142eabbb00d2cb635b
Author: James <u6079329@anu.edu.au>
Date:   Sun Sep 23 14:16:58 2018 +1000

    made variables private

commit cd484782d55d451f2ad77a707d966903ab61ad06
Author: James <u6079329@anu.edu.au>
Date:   Sun Sep 23 14:12:08 2018 +1000

    change in starting positions

commit fde37d1a1e7bd14713d80929d947d94f61a8b2a2
Author: James <u6079329@anu.edu.au>
Date:   Sun Sep 23 14:09:49 2018 +1000

    commit

commit 13044821b023a432d86d0d663cbaff39c2189561
Author: James <u6079329@anu.edu.au>
Date:   Sun Sep 23 14:07:00 2018 +1000

    added makePegPlacement, and deprecated methods

commit 6f46bbca250ec0ddaf2e227e7bd26839c22f1fa2
Merge: d755575 e2595e8
Author: u6406312 <u6406312@anu.edu.au>
Date:   Sun Sep 23 13:20:19 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit d75557563e539aeb4b4ec836bf4580284c7da466
Author: u6406312 <u6406312@anu.edu.au>
Date:   Sun Sep 23 13:19:55 2018 +1000

    Task 8.1

commit e2595e819a5df0d4ed007a1a81e4af8e8b05320f
Author: James <u6079329@anu.edu.au>
Date:   Sun Sep 23 13:10:12 2018 +1000

    added all pieces

commit 64972dc25f1b62e76489066d380188ede4e3525b
Author: u6406312 <u6406312@anu.edu.au>
Date:   Sun Sep 23 13:06:17 2018 +1000

    Task 8.1

commit 13fdb31b1584a7bfceb916d1c681a0989bf28bad
Author: u6406312 <u6406312@anu.edu.au>
Date:   Sun Sep 23 13:04:59 2018 +1000

    Task 8

commit f834f0ae43f4b0a447704ac8d5272334e3cb6410
Author: u6406312 <u6406312@anu.edu.au>
Date:   Sun Sep 23 12:31:55 2018 +1000

    does work?

commit 1585dc40b21705cecf9686792c25539fc0a7f159
Author: James <u6079329@anu.edu.au>
Date:   Sun Sep 23 10:12:02 2018 +1000

    added all pieces

commit 5afcc2376a600a1a1a8e0e986da533cb13c5929f
Merge: 65a7a73 bea69b7
Author: James <u6079329@anu.edu.au>
Date:   Sat Sep 22 17:50:13 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit 65a7a73fccd4d0cc89633bbdb9c7111dbc8254cb
Author: James <u6079329@anu.edu.au>
Date:   Sat Sep 22 17:48:48 2018 +1000

    task 7 complete except for a couple bugs

commit bea69b7c2a941cd8b6488892297575e9a00f8ba8
Author: u6609337 <u6609337@anu.edu.au>
Date:   Thu Sep 20 09:50:33 2018 +1000

    Try for the hint, and originality

commit b7dd521a72db76b2d3945f3106454af19ba995f8
Merge: f539b88 1b93372
Author: James <u6079329@anu.edu.au>
Date:   Wed Sep 19 19:29:47 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit f539b884444af245e55e7cd5bac2191f24805e4a
Author: James <u6079329@anu.edu.au>
Date:   Wed Sep 19 19:29:41 2018 +1000

    originality signed

commit 1b933722b9687f87b3289307c3aaf03cad9c6799
Merge: b2a1fde 51d6a1a
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Sep 19 18:15:03 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit b2a1fde4c7e152b9ed95b3c528317d6d30acd848
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Sep 19 18:06:27 2018 +1000

    Originality

commit 51d6a1a858674c637a9477f693dd4f59b695a642
Author: James <u6079329@anu.edu.au>
Date:   Wed Sep 19 16:44:07 2018 +1000

    originality signed

commit 22d683a2a6c20099c5145e522171c2e8fbc1ac1d
Author: James <u6079329@anu.edu.au>
Date:   Wed Sep 19 16:38:43 2018 +1000

    remove key press

commit aab7a1d9bc3aca3b54d0b8fc283ee18d8f387393
Author: James <u6079329@anu.edu.au>
Date:   Wed Sep 19 16:37:23 2018 +1000

    remove test statement

commit 2f39d4cfbb2b44b7a121a964670b61e492133b77
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sun Sep 16 18:53:08 2018 +1000

    Finished task 9 and passed all the tests

commit cae20eb9b1ac3febe32d31bd9842ffa4d1b5fe37
Merge: c32ee34 292cedc
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sun Sep 16 17:30:05 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit c32ee34276dd03183eca99bf27b4bf0df80e131e
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sun Sep 16 17:29:57 2018 +1000

    Finished task 6 and passed all the tests

commit 292cedcf4061589b68c0d4a01a924054e7729311
Author: Feier Xiao <feier.xiao@anu.edu.au>
Date:   Sun Sep 16 10:43:40 2018 +1000

    Update tasks.md

commit 206dc98bcb2399a9718d0bc71a2a07fefa5ea9db
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sun Sep 16 09:49:03 2018 +1000

    Reformat the code

commit aeac337fcb83b5b2e717c910075946fc80183f28
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sat Sep 15 08:45:53 2018 +1000

    Almost finished, haven't deal with the symmetry pieces

commit d5e87aa7cd35e994cd4554c68db09ee6b2af3e5d
Merge: bbc4b77 45524c6
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sat Sep 15 08:22:00 2018 +1000

    Merge branch 'master' of http://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit bbc4b773c15cd11eeacb75bb8d23319efa1c6d56
Merge: d3135e6 241df9c
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sat Sep 15 08:20:08 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit d3135e631031027ed970742e0e542f77165ec742
Author: u6609337 <u6609337@anu.edu.au>
Date:   Sat Sep 15 08:19:58 2018 +1000

    Try on Task 6, still got bugs

commit 45524c6847f69e649a991d15e71c9c9f13c1282b
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Fri Sep 14 13:44:35 2018 +1000

    Improved error message

commit 1f16cfeaa468e03fe67058c53af53c97dab20bb2
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Tue Sep 11 14:32:12 2018 +1000

    Further normalization

commit f9e67ea082a89320f58418fe0cd0932d7317f58c
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Tue Sep 11 08:13:31 2018 +1000

    Fix thanks to Yuan Chen

commit 7c9874a187459efbed7ac38c899db997b202cb1f
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Sat Sep 8 18:25:33 2018 +1000

    Another fix thanks to Ethal Askander

commit a716274b4d0b0c081969383a06344a592eecfd0a
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Sat Sep 8 17:50:45 2018 +1000

    Fix thanks to Ethal Askander

commit 30a45ea00f7be68e617476ae06ff0c7089a8e44c
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Sat Sep 8 16:41:59 2018 +1000

    Another fix

commit c66679c5a54ec1dd199df9192056f8f8ee0d3b9c
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Sat Sep 8 16:25:22 2018 +1000

    Fix thanks to Yuan Chen and others

commit eb9f3d33827d587348962d7eb2d393532921b691
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Fri Sep 7 16:08:56 2018 +1000

    More fixes, thanks to Zunren

commit 241df9c1f2c617859a40b5a921a4f51cbc4327df
Author: James <u6079329@anu.edu.au>
Date:   Fri Sep 7 15:38:16 2018 +1000

    Added rotations but very buggy

commit 1a0cdc7eb22632164d1d8c0dff873b7d41a0ff60
Author: James <u6079329@anu.edu.au>
Date:   Fri Sep 7 14:34:00 2018 +1000

    New class PieceView to be used to contain the piece Image.

commit 0766d1f63cd48a75ac158774d3db06457f620293
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Fri Sep 7 11:30:36 2018 +1000

    Fix broken tests for task 6.  Thanks to Siyu Jiang

commit c30a7c30ca4e2cc45e7ad9acff22fbf9f7ad20f6
Author: James <u6079329@anu.edu.au>
Date:   Wed Sep 5 21:09:32 2018 +1000

    Drag and snap to added, moved functionality in Viewer to Board

commit 561009f0bd384479f67750bbee3f70df0aab95ac
Author: James <u6079329@anu.edu.au>
Date:   Wed Sep 5 13:53:07 2018 +1000

    Events on mouse pressed and mouse released

commit b462b412d6adb6e280da295b8b1b7018cae745f5
Author: James <u6079329@anu.edu.au>
Date:   Wed Sep 5 13:32:47 2018 +1000

    Added gridlines and rescaling

commit a49a413fd4494c31ce76251d5ccf782bd47ed5cb
Author: James <u6079329@anu.edu.au>
Date:   Wed Sep 5 12:36:23 2018 +1000

    Added flipping, fixed a couple bugs with rotation
    changing the intial heights and widths of the pieces
    changed isPlacementStringValid to use the new infrastructure part 2

commit 36952a590634d5ff8070988b3db0784ce0cecfbb
Author: James <u6079329@anu.edu.au>
Date:   Wed Sep 5 12:33:28 2018 +1000

    Added flipping, fixed a couple bugs with rotation
    changing the intial heights and widths of the pieces
    changed isPlacementStringValid to use the new infrastructure

commit ba67eb714d9373acd5ca79a7170589c094587fb3
Merge: 122a0c5 ae00aa5
Author: James <u6079329@anu.edu.au>
Date:   Tue Sep 4 17:54:20 2018 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6406312/comp1110-ass2

commit 122a0c58d052b3cef0f38090eea0b32946fcd046
Author: James <u6079329@anu.edu.au>
Date:   Tue Sep 4 17:53:55 2018 +1000

    Added relative xy coordinates and rotations for them

commit ae00aa5063d81fdf720e18c06933ec402b803a46
Merge: efaae11 13c4581
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Wed Aug 29 18:16:42 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit efaae11688973b23788111030cc70870fee63f24
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Wed Aug 29 18:16:22 2018 +1000

    Some stuff for 1

commit 13c458193f11cdc12c7c250d21cfe1ec9bbaaf60
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Aug 29 18:15:45 2018 +1000

    Contribution

commit cd65612ddcc8d3dd765aa0c001b97abbf5389781
Merge: 8b4679f 7e14b11
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Aug 29 10:46:28 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit 8b4679f37b4c498141a2f3fbd8e1afc86ee629cd
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Aug 29 10:46:17 2018 +1000

    Refresh

commit 7e14b11bc68792977ef3ec0d688a5a72254e3c2b
Author: James <u6079329@anu.edu.au>
Date:   Wed Aug 29 10:28:35 2018 +1000

    originality part c

commit c56c2a3a555b2be868493aa45e8966fb7b1a78dd
Merge: 71639fa c4d6e21
Author: James <u6079329@anu.edu.au>
Date:   Wed Aug 29 10:24:33 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit 71639fa49560ae49e5469c48d7e716efcab0151d
Author: James <u6079329@anu.edu.au>
Date:   Wed Aug 29 10:24:17 2018 +1000

    originality part c

commit c4d6e21e6fa3650bcbf30272d41ec0594c74135b
Merge: 97c6e54 28c17f8
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Wed Aug 29 10:20:00 2018 +1000

    Cleanup

commit 28c17f8b6d3054421a71e93aa65a6db68f55db15
Merge: 41795d2 35b158e
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Aug 29 04:09:35 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit 41795d26b919325ffb909b1c4d1eec8d9deb5c66
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Aug 29 04:09:29 2018 +1000

    Fixed bugs, passed all test!

commit 35b158e469bce2225776ef09878d11734a6d16ec
Author: James <u6079329@anu.edu.au>
Date:   Wed Aug 29 00:00:46 2018 +1000

    commenting

commit 61c3809a3c26fa0c454f308e96363a3dae190890
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Aug 28 23:16:23 2018 +1000

    Slight change of the form

commit 8cfdfde859067bcfb29eac520daaa15adc7286fd
Merge: 2eaf40c 79c5246
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Aug 28 23:10:33 2018 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/TwistGame.java

commit 2eaf40cf4c38bb6ea6efa627bd9cd025133f3baa
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Aug 28 22:59:26 2018 +1000

    Fix few bugs

commit 97c6e540563b536cdfc0822c80f5b2e9809f6a25
Merge: b7a9b3b 79c5246
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Aug 28 22:55:49 2018 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/TwistGame.java

commit b7a9b3b29fe76e027d8e89a5f9579d0e7944324f
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Tue Aug 28 22:55:30 2018 +1000

    task2 done

commit 79c524654f45ce4b46ffff53982f15a5f2e9746b
Merge: 6e4fa0d b91574c
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Aug 28 22:49:24 2018 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/TwistGame.java

commit 6e4fa0df0620a4ee7dbd44ec4d5a6d227cf6ac1c
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Aug 28 22:47:16 2018 +1000

    task2 done

commit b91574c011fb557fd18aa5290749dcef68706d9c
Merge: d00e1c8 7081973
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Aug 28 22:37:37 2018 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/TwistGame.java

commit d00e1c8d38a3eedf26bb8a507401bcaa66abfdb5
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Tue Aug 28 22:36:43 2018 +1000

    task2 done

commit 7081973288da4783539e72fcf5a3195f77813654
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Aug 28 22:13:16 2018 +1000

    Task 5

commit d4f7e2774ad906ac67f90f781476e35bc0e8a58d
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Aug 28 18:28:49 2018 +1000

    Delete duplicate comments

commit be9ff632d084183de561190a0aaeeff3974c39f6
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Aug 28 18:24:26 2018 +1000

    Merge

commit 26c45de74559a77584d9b8593dbb89d97ba50e84
Merge: 36ed682 d932caa
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Aug 28 18:23:35 2018 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       src/comp1110/ass2/TwistGame.java

commit 36ed682da55ff6bb5eb09dd482f200ce7be7f492
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Aug 28 18:20:51 2018 +1000

    Task 2 3 and try to fix 5

commit d932caae32ecbff82b901dac3b738c7aed1cdff4
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Aug 28 14:30:44 2018 +1000

    task2.3

commit 733cbddc5221c802984c6143e663108ede919fe3
Author: u6406312 <u6406312@anu.edu.au>
Date:   Tue Aug 28 14:29:31 2018 +1000

    task2.2

commit 9e6b0ac914b331801cd942ce8c420416ec51ebd0
Author: u6609337 <u6609337@anu.edu.au>
Date:   Mon Aug 27 23:08:06 2018 +1000

    Delete ABC.java

commit 2eb8c9fafc97d64c1ac43227f9d9a36cb73e87f8
Author: James <u6079329@anu.edu.au>
Date:   Thu Aug 23 22:37:44 2018 +1000

    It's a thing of beauty

commit 62d75d4419f6f5d61f5570cc63e2bd6546031f0b
Author: James <u6079329@anu.edu.au>
Date:   Thu Aug 23 18:18:53 2018 +1000

    Rotations and flipping

commit 02679d456b6f335abf180dabe0fb9b0c86a2f0a0
Author: James <u6079329@anu.edu.au>
Date:   Thu Aug 23 16:44:09 2018 +1000

    Started task 4, displaying pieces

commit 050a496f6ae730d680f01c7babfac195b8340955
Merge: 34ddd17 e69fe1b
Author: James <u6079329@anu.edu.au>
Date:   Thu Aug 23 13:24:32 2018 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6406312/comp1110-ass2

commit e69fe1b6b72c4c00713fcadf92d263ec5e39340e
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Wed Aug 22 19:57:15 2018 +1000

    Some stuff for 1

commit 34ddd17b5ec032f678e307483294542737193b3c
Merge: 7883f2a d2c67e5
Author: James <u6079329@anu.edu.au>
Date:   Wed Aug 22 19:25:25 2018 +1000

    Merge remote-tracking branch 'origin/master'
    
    Conflicts:
            tests/gittest/A.java

commit 7883f2a6afc5833b693920240fd5c17343c74824
Author: James <u6079329@anu.edu.au>
Date:   Wed Aug 22 19:25:01 2018 +1000

    main

commit d2c67e556d46c29b721204392ecf5876244f5c25
Merge: 1b04d48 45486a5
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Aug 22 19:22:49 2018 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       tests/gittest/Main.java

commit 1b04d4858aeb24205cd568ccd75b73a2cc662230
Author: Bob <u6609337@anu.edu.au>
Date:   Wed Aug 22 19:21:05 2018 +1000

    Done

commit 45486a57b2fb69378439a3b3c6387a1f73053358
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Wed Aug 22 19:19:41 2018 +1000

    git test cindy 2

commit eafe12fe45bab3d98a93d29493f85fbcb58503c7
Merge: ece1b66 0f754e4
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Wed Aug 22 19:15:47 2018 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       tests/gittest/A.java

commit 0f754e4db7e7124c0ee215819d8069c4200b4620
Merge: b53e6c4 d94cb31
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Aug 22 19:14:52 2018 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       tests/gittest/Main.java

commit ece1b66ea6183511102d9e1843d14762da062896
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Wed Aug 22 19:13:17 2018 +1000

    git test cindy 2

commit d94cb3134498a400270b02eb9af7df870446be93
Author: Alice <u6079329@anu.edu.au>
Date:   Wed Aug 22 19:11:48 2018 +1000

    main

commit 362acc1d9fa17494aa872ac6ab4b6ad452434f08
Author: Alice <u6079329@anu.edu.au>
Date:   Wed Aug 22 19:10:56 2018 +1000

    main

commit b53e6c48ef223e9a8021a5caeae48971f16f05ec
Author: Bob <u6609337@anu.edu.au>
Date:   Wed Aug 22 19:10:36 2018 +1000

    Done

commit 60bb2ad1c693817b765137c7b1c52598d7e820bf
Author: Cindy <u1234567@anu.edu.au>
Date:   Wed Aug 22 19:09:11 2018 +1000

    git test cindy 2

commit 8e5f39288ff8263f29e5d6f64724b76bfa11fc79
Merge: 0474d1a b14b3a5
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Aug 22 18:59:27 2018 +1000

    Merge remote-tracking branch 'origin/master'

commit b14b3a551677b30e0c747f28413bd222e23b9909
Author: Cindy <u1234567@anu.edu.au>
Date:   Wed Aug 22 18:58:36 2018 +1000

    git test cindy

commit 0474d1a6d7d938ef18e2bb08290c943dc88426e0
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Aug 22 18:55:02 2018 +1000

    Done

commit 78927edc1cf843ef90a8cedf45dc22d2b6f93ce5
Author: James <u6079329@anu.edu.au>
Date:   Wed Aug 22 18:54:47 2018 +1000

    main

commit 0f306c99fb42de31f474ad981d69f7a5e7dfe50c
Author: Alice <u6079329@anu.edu.au>
Date:   Wed Aug 22 18:51:13 2018 +1000

    Done

commit 57025ea4bb9560f21f1c776bb146cf6b245791c1
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Aug 22 18:46:39 2018 +1000

    Originality

commit 997b519f9e3f23aff7f986b59e6304088798dcc7
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Wed Aug 22 18:45:04 2018 +1000

    originality state

commit 5e0faea6c30a4913819b28bc7a969c98152353f5
Merge: cebe53d 6f0929c
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Wed Aug 22 18:44:05 2018 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u6406312/comp1110-ass2-wed18i

commit 6f0929c1019e08f6c5512aff8da843d47611abfc
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Aug 22 18:43:45 2018 +1000

    Contribution

commit f4a942794b56167076b80c3603672fa13a3f6819
Author: James <u6079329@anu.edu.au>
Date:   Wed Aug 22 18:43:23 2018 +1000

    Contribution

commit e79caecf37da452905fd529bd8b85d54cf25dad0
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Aug 22 18:42:09 2018 +1000

    Originality and contribution

commit 11f989d0bf26a5b6d07c4a0471427354a1c26fb0
Author: James <u6079329@anu.edu.au>
Date:   Wed Aug 22 18:40:42 2018 +1000

    Originality

commit cebe53d0f7bfcb3df2e747b0e34ff3d4aaa87490
Merge: 5f13f59 13bc765
Author: Lachlan McVicar <u6406312@anu.edu.au>
Date:   Wed Aug 22 18:32:45 2018 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 42a8298842e1ce8318d610a5963605b46ad662f0
Merge: 5f13f59 13bc765
Author: u6609337 <u6609337@anu.edu.au>
Date:   Wed Aug 22 18:20:50 2018 +1000

    Merge branch 'master' of http://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 13bc76513d07fa0fbcd8eac41d0382385778a245
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Wed Aug 22 15:17:44 2018 +1000

    Change challenge to use minimal rotation, f2 rather than f4

commit 696847bf452c79608d0d3a355ad362dd1e0d5b0c
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Tue Aug 21 21:03:26 2018 +1000

    Fix bug noticed by Wu Qing

commit 49e301078370700eeeaa62489a4b6eaf0bbf775a
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Tue Aug 21 21:02:09 2018 +1000

    Fix ordering of placement strings, bug noticed by Wu Qing

commit 375795645b3a3802f70b39e9ea1c3e1cf8882962
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Tue Aug 21 20:54:44 2018 +1000

    Add missing piece, noticed by Wu Qing

commit 5c02552b593e1cea35566806e1d8b7f7a45acbd6
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Tue Aug 21 20:50:23 2018 +1000

    Fix first problem identified by Wu Qing

commit 5f13f59f16810f8b1bb2ba809525578a83ca90e4
Author: u6609337 <u6609337@anu.edu.au>
Date:   Tue Aug 21 14:33:04 2018 +1000

    The most tricky thing is the JavaFX coding..
    I don't know how the UI works and in what form the data was sent
    But I still make a rough structure and some comments of the idea to implement the games

commit 25fd0027719c42f7b4cae7091ec1437e5721fb16
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Tue Aug 21 12:15:20 2018 +1000

    Fix PlacementStringValidTest to call the correct method

commit 9eb5902a2f98ed73d2482385287d006f3fceb357
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Mon Aug 20 22:25:42 2018 +1000

    Added new unit tests

commit 1b53bd87835bb359f648d158fc1e2bfe90559cc9
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Mon Aug 20 22:13:08 2018 +1000

    Clarifications

commit eec0771bfc7d592013244c728d213eb93737c661
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Mon Aug 20 22:11:26 2018 +1000

    Clarify points in README

commit a5e84a6871c69600eb9611a6069052881540249f
Author: James <u6079329@anu.edu.au>
Date:   Sat Aug 18 12:33:57 2018 +1000

    Added node class and some new attributes to Peg and Piece

commit d9e37d8f256519192dfa295fc5c9179e3d1905a1
Author: James <u6079329@anu.edu.au>
Date:   Fri Aug 17 11:29:17 2018 +1000

    Intial structure

commit f34b230d29830f06f9a670ed0036710209b0b352
Author: u6406312 <u6406312@anu.edu.au>
Date:   Fri Aug 17 11:27:31 2018 +1000

    task2.2

commit b5e23300f38f68460b822a7ee010cee4a3539e61
Author: u6406312 <u6406312@anu.edu.au>
Date:   Fri Aug 17 11:23:55 2018 +1000

    task2.1

commit 7af72ba959aca3c6388be453420262516dde9486
Author: u6406312 <u6406312@anu.edu.au>
Date:   Fri Aug 17 10:47:31 2018 +1000

    task2

commit 153e3eb32f67c126ad63abf7aac37aafcdd712a9
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Thu Aug 16 21:29:51 2018 +1000

    Correction

commit 69bdedd51831fd60268b32a4950550ec6f1387d6
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Wed Aug 15 13:32:47 2018 +1000

    Make key methods public

commit 5b0d8ed5eb9af66482b185724eb9461ba9114d3a
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Wed Aug 15 13:32:17 2018 +1000

    Center pegs nicely

commit f7811be68e2a89cc9f62f5a7717980c39a0da574
Author: Steve Blackburn <steve.blackburn@anu.edu.au>
Date:   Mon Aug 13 22:57:32 2018 +1000

    Initial import
```
## Changes
``` diff
Only in comp1110-ass2/.idea: artifacts
Only in comp1110-ass2/.idea: codeStyles
Only in comp1110-ass2: META-INF
Only in comp1110-ass2: Presentation.pdf
diff -ru -x .git ../master/comp1110-ass2/admin/B-contribution.md comp1110-ass2/admin/B-contribution.md
--- ../master/comp1110-ass2/admin/B-contribution.md	2018-10-19 19:04:21.510579930 +1100
+++ comp1110-ass2/admin/B-contribution.md	2018-10-19 19:32:10.869576695 +1100
@@ -1,7 +1,7 @@
 We declare that the work toward our submission of Stage B was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
+* u6079329 30
+* u6609337 40
 * u0234567 30
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0234567)
+Signed: James Frampton Reid (u6079329), Feier Xiao (u6609337), and Lachlan McVicar (u6406312)
diff -ru -x .git ../master/comp1110-ass2/admin/B-originality.md comp1110-ass2/admin/B-originality.md
--- ../master/comp1110-ass2/admin/B-originality.md	2018-10-19 19:04:21.510579930 +1100
+++ comp1110-ass2/admin/B-originality.md	2018-10-19 19:32:10.869576695 +1100
@@ -1,9 +1,4 @@
 We declare that the work we have submitted for Stage B of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
 
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-*  ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: James Frampton Reid (u6079329), Feier Xiao (u6609337), and Lachlan McVicar (u6406312)
diff -ru -x .git ../master/comp1110-ass2/admin/C-contribution.md comp1110-ass2/admin/C-contribution.md
--- ../master/comp1110-ass2/admin/C-contribution.md	2018-10-19 19:04:21.510579930 +1100
+++ comp1110-ass2/admin/C-contribution.md	2018-10-19 19:32:10.869576695 +1100
@@ -1,7 +1,7 @@
 We declare that the work toward our submission of Stage C was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0234567 30
+* u6079329 30
+* u6609337 50
+* u6406312 20
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0234567)
+Signed: James Frampton Reid (u6079329), Feier Xiao (u6609337), and Lachlan McVicar (u6406312)
diff -ru -x .git ../master/comp1110-ass2/admin/C-originality.md comp1110-ass2/admin/C-originality.md
--- ../master/comp1110-ass2/admin/C-originality.md	2018-10-19 19:04:21.510579930 +1100
+++ comp1110-ass2/admin/C-originality.md	2018-10-19 19:32:10.869576695 +1100
@@ -1,9 +1,4 @@
 We declare that the work we have submitted for Stage C of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
-
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
-
-*  ....
-
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Task 2: the idea to use indexOf in this function came from https://stackoverflow.com/questions/506105/how-can-i-check-if-a-single-character-appears-in-a-string
+Signed: James Frampton Reid (u6079329), Feier Xiao (u6609337), and Lachlan McVicar (u6406312)
Only in ../master/comp1110-ass2/admin: D-originality-u1234567.md
Only in comp1110-ass2/admin: D-originality-u6079329.md
Only in comp1110-ass2/admin: D-originality-u6406312.md
Only in comp1110-ass2/admin: D-originality-u6609337.md
Only in ../master/comp1110-ass2/admin: E-originality-u1234567.md
Only in comp1110-ass2/admin: E-originality-u6079329.md
Only in comp1110-ass2/admin: E-originality-u6406312.md
Only in comp1110-ass2/admin: E-originality-u6609337.md
diff -ru -x .git ../master/comp1110-ass2/admin/F-contribution.md comp1110-ass2/admin/F-contribution.md
--- ../master/comp1110-ass2/admin/F-contribution.md	2018-10-19 19:04:21.510579930 +1100
+++ comp1110-ass2/admin/F-contribution.md	2018-10-19 19:32:10.869576695 +1100
@@ -1,8 +1,8 @@
 We declare that the work toward our submission of Stage F was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0123456 30
+* u6079329 30
+* u6609337 40
+* u6406312 30
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: James Frampton Reid (u6079329), Feier Xiao (u6609337), and Lachlan McVicar (u6406312)
 
diff -ru -x .git ../master/comp1110-ass2/admin/F-originality.md comp1110-ass2/admin/F-originality.md
--- ../master/comp1110-ass2/admin/F-originality.md	2018-10-19 19:04:21.510579930 +1100
+++ comp1110-ass2/admin/F-originality.md	2018-10-19 19:32:10.869576695 +1100
@@ -5,5 +5,7 @@
 * The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
 
 * ....
+the arrow key image is taken from
+https://www.101computing.net/wp/wp-content/uploads/arrowKeys-300x205.png
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: Signed: James Frampton Reid (u6079329), Feier Xiao (u6609337), and Lachlan McVicar (u6406312)
\ No newline at end of file
Only in ../master/comp1110-ass2/admin: F-review-u1234567.md
Only in comp1110-ass2/admin: F-review-u6079329.md
Only in comp1110-ass2/admin: F-review-u6406312.md
Only in comp1110-ass2/admin: F-review-u6609337.md
Only in ../master/comp1110-ass2/admin: G-best-u1234567.md
Only in comp1110-ass2/admin: G-best-u6079329.md
Only in comp1110-ass2/admin: G-best-u6406312.md
Only in comp1110-ass2/admin: G-best-u6609337.md
diff -ru -x .git ../master/comp1110-ass2/admin/G-contribution.md comp1110-ass2/admin/G-contribution.md
--- ../master/comp1110-ass2/admin/G-contribution.md	2018-10-19 19:04:21.510579930 +1100
+++ comp1110-ass2/admin/G-contribution.md	2018-10-19 19:32:10.869576695 +1100
@@ -1,8 +1,8 @@
 We declare that the work toward our submission of Stage G was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0123456 30
+* u6079329 40
+* u6609337 40
+* u6406312 20
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: James Frampton Reid (u6079329), Feier Xiao (u6609337), and Lachlan McVicar (u6406312)
 
diff -ru -x .git ../master/comp1110-ass2/admin/G-features.md comp1110-ass2/admin/G-features.md
--- ../master/comp1110-ass2/admin/G-features.md	2018-10-19 19:04:21.510579930 +1100
+++ comp1110-ass2/admin/G-features.md	2018-10-19 19:32:10.869576695 +1100
@@ -9,5 +9,14 @@
  - Generates basic starting piece placements (Task 8)
  - Implements hints (Task 10)
  - Implements interesting starting placements (Task 11)
+ - In depth Tutorial
+ - Luxury relaxing aesthetics
+ - Fantastic victory message
+ - Advanced Piece selection interface
+ - Working Timer
+ - Full size dictionary (26 millions distinct placements)
+   (If needed, contact me and I can send it, 1.5GB csv file is too big to put in the package)
+ - Fast response in getting hint
+ - Interesting implement for the piece
 
 additional features...
diff -ru -x .git ../master/comp1110-ass2/admin/G-originality.md comp1110-ass2/admin/G-originality.md
--- ../master/comp1110-ass2/admin/G-originality.md	2018-10-19 19:04:21.510579930 +1100
+++ comp1110-ass2/admin/G-originality.md	2018-10-19 19:32:10.869576695 +1100
@@ -1,9 +1,20 @@
 We declare that the work we have submitted for Stage G of this assignment and all stages before it is entirely our own work, with the following documented exceptions:
 
-* The idea of using <...> to make the game run faster came from a discussion with <...> (noted in source code comments)
+Lachlan McVicar (u6406312):
 
-* The code in class <...> is based on a solution we found when researching the problem (URL provided in source code comments)
+Waldobot uses this code to fix an exception:
+    try
+    {
+    Robot bot = new Robot();
+    bot.mouseMove(50, 50);
+    }
+    catch (AWTException e)
+    {
+    e.printStackTrace();
+    }
+    this code is sourced from here:
+    https://stackoverflow.com/questions/13785747/robot-class-unhandled-exception-type-awtexception
 
-* ....
+    All images are sourced externally belong to their respective oweners
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: James Frampton Reid (u6079329), Feier Xiao (u6609337), and Lachlan McVicar (u6406312)
diff -ru -x .git ../master/comp1110-ass2/admin/H-contribution.md comp1110-ass2/admin/H-contribution.md
--- ../master/comp1110-ass2/admin/H-contribution.md	2018-10-19 19:04:21.510579930 +1100
+++ comp1110-ass2/admin/H-contribution.md	2018-10-19 19:32:10.869576695 +1100
@@ -1,8 +1,9 @@
 We declare that the work toward our submission of Stage H was distributed among the group members as follows:
 
-* u2345678 30
-* u3456789 40
-* u0123456 30
+* u6079329 40
+* u6609337 40
+* u6406312 20
+
+Signed: James Frampton Reid (u6079329), Feier Xiao (u6609337), and Lachlan McVicar (u6406312)
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
 
diff -ru -x .git ../master/comp1110-ass2/admin/H-originality.md comp1110-ass2/admin/H-originality.md
--- ../master/comp1110-ass2/admin/H-originality.md	2018-10-19 19:04:21.514580002 +1100
+++ comp1110-ass2/admin/H-originality.md	2018-10-19 19:32:10.869576695 +1100
@@ -6,5 +6,6 @@
 
 * ....
 
-Signed: Mary Jones (u2345678), Bob Smith (u3456789), and Sue Black (u0123456)
+Signed: James Frampton Reid (u6079329), Feier Xiao (u6609337), and Lachlan McVicar (u6406312)
+
 
diff -ru -x .git ../master/comp1110-ass2/admin/tasks.md comp1110-ass2/admin/tasks.md
--- ../master/comp1110-ass2/admin/tasks.md	2018-10-19 19:04:21.514580002 +1100
+++ comp1110-ass2/admin/tasks.md	2018-10-19 19:32:10.869576695 +1100
@@ -9,24 +9,36 @@
 
 ## Week 5
 
-Zhang San: Task 3 isPiecePlacementWellFormed - 21 Aug
-
-Jane Bloggs: Task 4 getNeighbours - 23 Aug
-
-Erika Mustermann: Task 6 getViablePiecePlacements - 24 Aug (depends on Task 3)
+Lachlan McVicar task 2;
+Feier Xiao task 3;
 
 ## Week 6
 
-...
+James Frampton Reid task 4;
+Feier Xiao task 5;
 
 ## Mid-Semester Break
 
+Feier Xiao task 6, 9;
+James Frampton Reid task 7;
+Lachlan McVicar task 8;
+
 ## Week 7
 
+Feier Xiao task 10, 11;
+
 ## Week 8
 
-## Week 9
+Feier Xiao task 10;
+Lachlan McVicar fix UI;
 
-## Week 10
+## Week 9 - 10
+
+Feier Xiao task 11
+Feier Xiao task 6, 9 (optimization);
+James Frampton Reid task 6, 9 (optimization);
 
 ## Week 11
+
+Group fix all problems left
+
Only in comp1110-ass2/assets: Rules
Only in comp1110-ass2: feedback.md
Only in comp1110-ass2: game.jar
Only in comp1110-ass2/src: META-INF
Only in comp1110-ass2/src/comp1110/ass2: Colour.class
Only in comp1110-ass2/src/comp1110/ass2: Colour.java
Only in comp1110-ass2/src/comp1110/ass2: Node.class
Only in comp1110-ass2/src/comp1110/ass2: Node.java
Only in comp1110-ass2/src/comp1110/ass2: Objective$1.class
Only in comp1110-ass2/src/comp1110/ass2: Objective.class
Only in comp1110-ass2/src/comp1110/ass2: Objective.java
Only in comp1110-ass2/src/comp1110/ass2: Peg$1.class
Only in comp1110-ass2/src/comp1110/ass2: Peg.class
Only in comp1110-ass2/src/comp1110/ass2: Peg.java
Only in comp1110-ass2/src/comp1110/ass2: Piece.class
Only in comp1110-ass2/src/comp1110/ass2: Piece.java
Only in comp1110-ass2/src/comp1110/ass2: Placement.csv
Only in comp1110-ass2/src/comp1110/ass2: ProblemSet.csv
Only in comp1110-ass2/src/comp1110/ass2: Solutions.csv
Only in comp1110-ass2/src/comp1110/ass2: TwistGame.class
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/TwistGame.java comp1110-ass2/src/comp1110/ass2/TwistGame.java
--- ../master/comp1110-ass2/src/comp1110/ass2/TwistGame.java	2018-10-19 19:04:21.542580509 +1100
+++ comp1110-ass2/src/comp1110/ass2/TwistGame.java	2018-10-19 19:32:10.909577441 +1100
@@ -1,6 +1,13 @@
+/*
+Task 2 was written by Lachlan McVicar
+Task 2 3 5 6 9 10 11 was written by Feier Xiao (u6609337)
+Optimization for task 6 9 was done by James Frampton Reid (u6079329) and Feier Xiao (u6609337)
+ */
+
 package comp1110.ass2;
 
-import java.util.Set;
+import java.io.*;
+import java.util.*;
 
 /**
  * This class provides the text interface for the Twist Game
@@ -9,94 +16,958 @@
  * (http://www.smartgames.eu/en/smartgames/iq-twist)
  */
 public class TwistGame {
+    /**
+     * Determine whether a piece or peg placement is well-formed according to the following:
+     * - it consists of exactly four characters
+     * - the first character is in the range a .. l (pieces and pegs)
+     * - the second character is in the range 1 .. 8 (columns)
+     * - the third character is in the range A .. D (rows)
+     * - the fourth character is in the range 0 .. 7 (if a piece) or is 0 (if a peg)
+     *
+     * @param piecePlacement A string describing a single piece or peg placement
+     * @return True if the placement is well-formed
+     */
+
+    public static boolean isPlacementWellFormed(String piecePlacement) {
+        int loop = piecePlacement.length();
+        int count = 0;
+        String at1 = "abcdefghijkl";
+        String at2 = "12345678";
+        String at3 = "ABCD";
+        String at4 = "01234567";
+        String atSpecial = "ijkl";
+        if (loop % 4 != 0) {
+            return false;
+        }
+        while (loop > 0) {
+            if (at1.indexOf(piecePlacement.charAt(count)) == -1) {
+                return false;
+            }
+            if (at2.indexOf(piecePlacement.charAt(count + 1)) == -1) {
+                return false;
+            }
+            if (at3.indexOf(piecePlacement.charAt(count + 2)) == -1) {
+                return false;
+            }
+            if (at4.indexOf(piecePlacement.charAt(count + 3)) == -1) {
+                return false;
+            }
+            if (atSpecial.indexOf(piecePlacement.charAt(count)) != -1 && piecePlacement.charAt(count + 3) != '0') {
+                return false;
+            }
+            count = count + 4;
+            loop = loop - 4;
+
+
+        }
+        return true;
+    }
 
-  /**
-   * Determine whether a piece or peg placement is well-formed according to the following:
-   * - it consists of exactly four characters
-   * - the first character is in the range a .. l (pieces and pegs)
-   * - the second character is in the range 1 .. 8 (columns)
-   * - the third character is in the range A .. D (rows)
-   * - the fourth character is in the range 0 .. 7 (if a piece) or is 0 (if a peg)
-   *
-   * @param piecePlacement A string describing a single piece or peg placement
-   * @return True if the placement is well-formed
-   */
-  public static boolean isPlacementWellFormed(String piecePlacement) {
     // FIXME Task 2: determine whether a piece or peg placement is well-formed
-    return false;
-  }
 
-  /**
-   * Determine whether a placement string is well-formed:
-   * - it consists of exactly N four-character piece placements (where N = 1 .. 15);
-   * - each piece or peg placement is well-formed
-   * - each piece or peg placement occurs in the correct alphabetical order (duplicate pegs can be in either order)
-   * - no piece or red peg appears more than once in the placement
-   * - no green, blue or yellow peg appears more than twice in the placement
-   *
-   * @param placement A string describing a placement of one or more pieces and pegs
-   * @return True if the placement is well-formed
-   */
-  public static boolean isPlacementStringWellFormed(String placement) {
-    // FIXME Task 3: determine whether a placement is well-formed
-    return false;
-  }
-
-  /**
-   * Determine whether a placement string is valid.  To be valid, the placement
-   * string must be well-formed and each piece placement must be a valid placement
-   * according to the rules of the game.
-   * - pieces must be entirely on the board
-   * - pieces must not overlap each other
-   * - pieces may only overlap pegs when the a) peg is of the same color and b) the
-   *   point of overlap in the piece is a hole.
-   *
-   * @param placement A placement sequence string
-   * @return True if the placement sequence is valid
-   */
-  public static boolean isPlacementStringValid(String placement) {
-    // FIXME Task 5: determine whether a placement string is valid
-    return false;
-  }
-
-  /**
-   * Given a string describing a placement of pieces and pegs, return a set
-   * of all possible next viable piece placements.   To be viable, a piece
-   * placement must be a valid placement of a single piece.  The piece must
-   * not have already been placed (ie not already in the placement string),
-   * and its placement must be valid.   If there are no valid piece placements
-   * for the given placement string, return null.
-   *
-   * When symmetric placements of the same piece are viable, only the placement
-   * with the lowest rotation should be included in the set.
-   *
-   * @param placement A valid placement string (comprised of peg and piece placements)
-   * @return An set of viable piece placements, or null if there are none.
-   */
-  public static Set<String> getViablePiecePlacements(String placement) {
-    // FIXME Task 6: determine the set of valid next piece placements
-    return null;
-  }
-
-  /**
-   * Return an array of all unique solutions for a given starting placement.
-   *
-   * Each solution should be a 32-character string giving the placement sequence
-   * of all eight pieces, given the starting placement.
-   *
-   * The set of solutions should not include any symmetric piece placements.
-   *
-   * In the IQ-Twist game, valid challenges can have only one solution, but
-   * other starting placements that are not valid challenges may have more
-   * than one solution.  The most obvious example is the unconstrained board,
-   * which has very many solutions.
-   *
-   * @param placement A valid piece placement string.
-   * @return An array of strings, each 32-characters long, describing a unique
-   * unordered solution to the game given the starting point provided by placement.
-   */
-  public static String[] getSolutions(String placement) {
-    // FIXME Task 9: determine all solutions to the game, given a particular starting placement
-    return null;
-  }
+
+//    // I rewrite your code to see if it can be optimised -- Feier Xiao
+//    public static boolean isPlacementWellFormed(String piecePlacement) {
+//        if (piecePlacement.length() != 4) {
+//            return false;
+//        }
+//        if (piecePlacement.charAt(0) >= 'i' && piecePlacement.charAt(0) <= 'l') {
+//            if (piecePlacement.charAt(3) != '0') {
+//                return false;
+//            }
+//        }
+//        if (piecePlacement.charAt(0) >= 'a' && piecePlacement.charAt(0) <= 'l') {
+//            if (piecePlacement.charAt(1) >= '1' && piecePlacement.charAt(1) <= '8') {
+//                if (piecePlacement.charAt(2) >= 'A' && piecePlacement.charAt(2) <= 'D') {
+//                    if (piecePlacement.charAt(3) >= '0' && piecePlacement.charAt(3) <= '7') {
+//                        return true;
+//                    }
+//                }
+//            }
+//        }
+//        return false;
+//
+//    }
+
+    /**
+     * Determine whether a placement string is well-formed:
+     * - it consists of exactly N four-character piece placements (where N = 1 .. 15);
+     * - each piece or peg placement is well-formed
+     * - each piece or peg placement occurs in the correct alphabetical order (duplicate pegs can be in either order)
+     * - no piece or red peg appears more than once in the placement
+     * - no green, blue or yellow peg appears more than twice in the placement
+     *
+     * @param placement A string describing a placement of one or more pieces and pegs
+     * @return True if the placement is well-formed
+     */
+    public static boolean isPlacementStringWellFormed(String placement) {
+        // The array for the pieces and pegs
+        // Every time I got a piece from the placement, minus 1
+        // At the end, check whether anyone is smaller than 0
+        int[] count = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2};
+        char lastPiece = 'a';
+        int index;
+
+        if (placement.length() == 0 || placement.length() % 4 != 0) {
+            return false;
+        }
+        for (int i = 0; i < placement.length() / 4; i++) {
+            if (!isPlacementWellFormed(placement.substring(4 * i, 4 + 4 * i))) {
+                return false;
+            }
+            // Get the index by ASCII value of each placement
+            index = placement.charAt(4 * i) - 'a';
+            // Check whether the last piece is bigger than current
+            if (placement.charAt(4 * i) < lastPiece) {
+                return false;
+            }
+            lastPiece = placement.charAt(4 * i);
+            // Minus the counter
+            count[index] -= 1;
+        }
+        // Check the counter, everyone shouldn't less than 0
+        for (int i : count) {
+            if (i < 0) {
+                return false;
+            }
+        }
+        return true;
+
+        // FIXME Task 3: determine whether a placement is well-formed
+    }
+
+    /**
+     * Determine whether a placement string is valid.  To be valid, the placement
+     * string must be well-formed and each piece placement must be a valid placement
+     * according to the rules of the game.
+     * - pieces must be entirely on the board
+     * - pieces must not overlap each other
+     * - pieces may only overlap pegs when the a) peg is of the same color and b) the
+     * point of overlap in the piece is a hole.
+     *
+     * @param placement A placement sequence string
+     * @return True if the placement sequence is valid
+     */
+    public static boolean isPlacementStringValid(String placement) {
+
+        char pieceType;
+        String piecePlacement;
+        int column, row, orientation, count;
+        Node[][] nodes = new Node[4][8];
+        // Count the number of the placements
+
+        Piece piece;
+
+        initNodes(nodes);
+        if (!isPlacementStringWellFormed(placement)) {
+            return false;
+        }
+        // Set all the pegs first, so I reverse the placement order
+        count = placement.length() / 4;
+        for (int i = count - 1; i >= 0; i--) {
+            pieceType = placement.charAt(4 * i);
+            piecePlacement = placement.substring(i * 4,i*4+4);
+
+            if (!setPieces(nodes, piecePlacement, pieceType)) {
+                return false;
+            }
+        }
+        return true;
+        // FIXME Task 5: determine whether a placement string is valid
+    }
+
+    public static void initNodes(Node[][] nodes) {
+        for (int i = 0; i < nodes.length; i++) {
+            for (int j = 0; j < nodes[i].length; j++) {
+                nodes[i][j] = new Node(0, null, null);
+            }
+        }
+    }
+
+    public static boolean setPieces(Node[][] nodes, String placement, char pieceType) {
+
+        switch (pieceType) {
+            case 'a':
+            case 'b':
+            case 'c':
+            case 'd':
+            case 'e':
+            case 'f':
+            case 'g':
+            case 'h': return Node.setPiece(nodes,new Piece(placement));
+
+            case 'i':
+            case 'j':
+            case 'k':
+            case 'l': return Node.setPeg(nodes,Peg.getPegForPlacement(placement));
+
+        }
+        return false;
+    }
+
+    /**
+     * Given a string describing a placement of pieces and pegs, return a set
+     * of all possible next viable piece placements.   To be viable, a piece
+     * placement must be a valid placement of a single piece.  The piece must
+     * not have already been placed (ie not already in the placement string),
+     * and its placement must be valid.   If there are no valid piece placements
+     * for the given placement string, return null.
+     * <p>
+     * When symmetric placements of the same piece are viable, only the placement
+     * with the lowest rotation should be included in the set.
+     *
+     * @param placement A valid placement string (comprised of peg and piece placements)
+     * @return An set of viable piece placements, or null if there are none.
+     */
+    public static Set<String> getViablePiecePlacements(String placement) {
+        char ch;
+        int[] placedPieces = new int[8];
+        Set<String> viable = new HashSet<>();
+
+        // Record every placed pieces
+        for (int i = 0; i < placement.length() / 4; i++) {
+            ch = placement.charAt(4 * i);
+            if (isPiece(ch)) {
+                placedPieces[ch - 'a'] = 1;
+            } else {
+                break;
+            }
+        }
+
+        // Process every unplaced pieces
+        for (int i = 0; i < 8; i++) {
+            if (placedPieces[i] == 0) {
+                ch = (char) ('a' + i);
+
+                viable.addAll(testNewPieces(placement, ch));
+            }
+        }
+
+        if (viable.isEmpty()) {
+            return null;
+        } else {
+            return viable;
+        }
+        // FIXME Task 6: determine the set of valid next piece placements
+    }
+
+    // Return True if it is one of the pieces
+    public static boolean isPiece(char ch) {
+        if (ch >= 'a' & ch <= 'h') {
+            return true;
+        }
+        return false;
+    }
+
+    // Try every possibility for the pieces
+    public static Set<String> testNewPieces(String placement, char ch) {
+        Set<String> viable = new HashSet<>();
+        String newPiece, originalPiece, newPlacement;
+        int maxRow, maxColumn;
+
+        // Get the occupation situation of the board
+        // And never put a new piece on it
+        int[][] occupation = getBoardSituation(placement);
+
+        String[] splitedString = findInsertPosition(placement, ch);
+
+        // If it is not c or h piece, it can't be put at the edge
+        if (ch == 'c' || ch == 'h') {
+            maxColumn = 9;
+            maxRow = 4;
+        } else {
+            maxColumn = 8;
+            maxRow = 3;
+        }
+        // For every possibility
+        for (int i = 1; i < maxColumn; i++) {
+            for (int j = 0; j < maxRow; j++) {
+                for (int k = 0; k < 8; k++) {
+                    // This place has already been occupied
+                    newPiece = ch + Integer.toString(i) + (char) ('A' + j) + Integer.toString(k);
+                    if (!getPieceSituation(occupation, new Piece(newPiece))) {
+                        continue;
+                    }
+                    newPlacement = splitedString[0] + newPiece + splitedString[1];
+                    // Reduce strict symmetry, remove all c and h pieces with rotation greater than 4
+                    if ((newPiece.charAt(0) == 'c' || newPiece.charAt(0) == 'h') && newPiece.charAt(3) >= '4') {
+                        continue;
+                    }
+                    // Reduce weak symmetry
+                    // For b, c and h pieces, minus 2
+                    if ((newPiece.charAt(0) == 'b' || newPiece.charAt(0) == 'c' || newPiece.charAt(0) == 'h') && (newPiece.charAt(3) == '2' | newPiece.charAt(3) == '3' | newPiece.charAt(3) == '6' | newPiece.charAt(3) == '7')) {
+                        originalPiece = newPiece.substring(0, 3) + (char) (newPiece.charAt(3) - 2);
+                    } else if ((newPiece.charAt(0) == 'e') && (newPiece.charAt(3) >= '4')) {
+                        originalPiece = newPiece.substring(0, 3) + ((newPiece.charAt(3) - '0' + 1) % 4);
+                    } else if ((newPiece.charAt(0) == 'f') && (newPiece.charAt(3) >= '4')) {
+                        originalPiece = newPiece.substring(0, 3) + ((newPiece.charAt(3) - '0' + 2) % 4);
+                    } else {
+                        originalPiece = null;
+                    }
+
+                    // If the original piece is in the viable
+                    // We don't need the the symmetry piece no matter it is viable or not,
+                    if (originalPiece != null) {
+                        if (viable.contains(originalPiece)) {
+                            continue;
+                        }
+                    }
+
+                    if (isPlacementStringValid(newPlacement)) {
+                        viable.add(newPiece);
+                    }
+                }
+            }
+        }
+        return viable;
+    }
+
+    //Takes a placement string of any length using the standard encoding
+    //Returns and 8 by 4 int array that represents the board state
+    //Has 1s where a space is occupied by a piece and 0s elsewhere
+    public static int[][] getBoardSituation(String placement) {
+        int[][] situation = new int[8][4];
+        char id;
+        int row, column, orientation;
+
+        //loop through every piecePlacement in placement
+        pieceLoop:
+        for (int i = 0; i < placement.length(); i = i + 4) {
+            id = placement.charAt(i);
+            //break if the pegs have been reached
+            switch (id) {
+                case 'i':
+                case 'j':
+                case 'k':
+                case 'l':
+                    break pieceLoop;//break the loop not the case statement
+            }
+            //get the piece for the given id
+            Piece piece = new Piece(placement.substring(i,i+4));
+
+            //decode the other attributes of the piece
+            column = piece.getColumn();
+            row = piece.getRow();
+
+            //Loop through every set of coordinates in xy
+            for (int j = 0;j<piece.getLength(); j++) {
+
+                int[] coordinate = piece.getRelativeCoordinate(j);
+
+                //set nodes at coordinates to be 1
+                situation[column + coordinate[0]][row + coordinate[1]] = 1;
+            }
+        }
+        return situation;
+    }
+
+    // Check if the piece is available
+    // Like the last one, but for one piece only
+    // Given the situation and check if it is 1
+    // If so, return false
+    // I try to copy some of your code but failed
+
+
+    /*
+    Takes a two dimensionaly array representing the board state and updates to include a new piece
+
+    situation: the current board state; 0:unoccupied, 1:occupied (By a piece)
+
+    newPiece: String representation of a single piece follows encoding from other sections
+
+     */
+
+    //REVIEW THIS Feier
+    //Takes a board situation: an 8 by 4 int array with 1s where a piece is and 0s elsewhere
+    //Takes a new Piece placment: a String that follows standard coding
+    //return true if the newPiece can be placed on the board represented by situation, false otherwise
+    public static boolean getPieceSituation(int[][] situation, Piece newPiece) {
+
+
+
+        //Loop through every set of coordinates in xy
+        for (int i = 0; i < newPiece.getLength();i++) {
+
+            int[] c = newPiece.getRelativeCoordinate(i);
+
+            //check whether the coordinates are in the correct range
+            if (newPiece.getColumn() + c[0] < 0 || newPiece.getColumn() + c[0] > 7 || newPiece.getRow() + c[1] < 0 || newPiece.getRow() + c[1] > 3) {
+                return false;
+            }
+            //check if the coordinate in situation is already occupied
+            if (situation[newPiece.getColumn() + c[0]][newPiece.getRow() + c[1]] == 1) {
+                //if so return false
+                return false;
+            }
+        }
+        //only return true if no intersection was found
+        return true;
+    }
+
+    public static String[] findInsertPosition(String placement, char ch) {
+
+        String[] splitedString = new String[2];
+
+        /*
+        if (placement.equals("")) {
+            splitedString[0] = "";
+            splitedString[1] = "";
+            return splitedString;
+        }
+        */
+
+        // Utmost 8 times, till we find the right place to insert the piece
+        for (int i = 0;i < placement.length(); i = i + 4) {
+            char currentPiece;
+            currentPiece = placement.charAt(i);
+
+            if (ch < currentPiece){
+                splitedString[0] = placement.substring(0,i);
+                splitedString[1] = placement.substring(i);
+                return splitedString;
+            }
+        }
+
+        splitedString[0] = placement;
+        splitedString[1] = "";
+
+        return splitedString;
+    }
+
+    /**
+     * Return an array of all unique solutions for a given starting placement.
+     * <p>
+     * Each solution should be a 32-character string giving the placement sequence
+     * of all eight pieces, given the starting placement.
+     * <p>
+     * The set of solutions should not include any symmetric piece placements.
+     * <p>
+     * In the IQ-Twist game, valid challenges can have only one solution, but
+     * other starting placements that are not valid challenges may have more
+     * than one solution.  The most obvious example is the unconstrained board,
+     * which has very many solutions.
+     *
+     * @param placement A valid piece placement string.
+     * @return An array of strings, each 32-characters long, describing a unique
+     * unordered solution to the game given the starting point provided by placement.
+     */
+    public static String[] getSolutions(String placement) {
+        int resultLength = placement.length();
+        Set<String> solutions = new HashSet<>();
+
+        //New hashSet to contain piece placements already made so there is no repeated tests
+        HashSet<Piece> blackList = new HashSet<>();
+
+        Set<String> viable = getViablePiecePlacements(placement);
+
+        HashSet<Piece> viablePieces = new HashSet<>();
+
+        for(String s:viable){
+
+            viablePieces.add(new Piece(s));
+
+        }
+
+        // Get the length of the peg
+        for (int i = 0; i < placement.length() / 4; i++) {
+            if (isPiece(placement.charAt(4 * i))) {
+                resultLength = resultLength - 4;
+            } else {
+                break;
+            }
+        }
+        // Get the result length by adding 32
+        resultLength = resultLength + 32;
+        setNextPlacement(solutions, placement, resultLength, blackList, viablePieces);
+        String[] result = solutions.toArray(new String[0]);
+
+        return result;
+        // FIXME Task 9: determine all solutions to the game, given a particular starting placement
+    }
+
+    public static void setNextPlacement(Set<String> solutions, String placement, int resultLength, HashSet<Piece> blackList, HashSet<Piece> viable) {
+        int[] pieces = new int[8];
+        //Set<String> viable;
+        String newPlacement;
+        String[] splitedString;
+
+        // If the length of the List is 32, that is the full solutions
+        if (placement.length() == resultLength) {
+            solutions.add(placement.substring(0, 32));
+            return;
+        }
+        // There is no further viable piece to put
+        if (viable == null) {
+            return;
+        }
+        // Set the flag in the pieces array 1 if it is placed
+        for (int i = 0; i < placement.length() / 4; i++) {
+            if (placement.charAt(4 * i) > 'h') {
+                break;
+            } else {
+                pieces[placement.charAt(4 * i) - 'a'] = 1;
+            }
+        }
+        // See if the current placement have solution
+        // It should have all the pieces placed otherwise it is invalid
+        for (Piece s : viable) {
+            if(!blackList.contains(s)){
+                pieces[s.getId() - 'a'] = 1;
+            }
+        }
+
+        for (int i : pieces) {
+            if (i == 0) {
+                return;
+            }
+        }
+        // Use recursion to find every viable after another till the solutions are found
+        for (Piece s : viable) {
+            splitedString = findInsertPosition(placement, s.getId());
+            newPlacement = splitedString[0] + s.getEncoding() + splitedString[1];
+
+            // Black list works here
+            if(!blackList.contains(s)){
+
+                HashSet<Piece> nextViable = removeNonViablePlacements(viable,s);
+                setNextPlacement(solutions, newPlacement, resultLength,(HashSet<Piece>) blackList.clone(),nextViable);
+                // The piece come here and it needs to be added to the black list
+                blackList.add(s);
+            }
+        }
+    }
+
+    //REVIEW THIS
+    //Function to take a set of viable placements and one specific viable piece placement
+    //Return a set of piece placements that are still viable with the new piecePlacement
+    public static HashSet<Piece> removeNonViablePlacements(Set<Piece> viable, Piece nextPiece){
+
+        //Take piecePlacement and set it into an array
+        int[][] situation = nextPiece.getPieceSituation();
+        //New set to contain the new viable pieces
+        HashSet<Piece> nextViable = new HashSet<>();
+
+        //loop through elements of viable
+        for(Piece v : viable){
+
+            //for each element check whether it is a different type to piecePlacement
+            //and check if it intersects with the piecePlacement
+            if(v.getId() != nextPiece.getId() && getPieceSituation(situation,v)){
+                nextViable.add(v);
+            }
+        }
+
+        //return null if size is zero
+        if(nextViable.size() == 0){
+            return null;
+        }
+
+        return nextViable;
+    }
+
+
+    // Get hint, return null means no solution, String[] are hints for different solutions
+    public static String getHint(String placement, Objective objective) {
+        String solution = objective.getSolutionPlacement();
+        Set<String> correctPiecesSet = new HashSet<>();
+        String[] symmetricalPieces;
+        List<String> temp = new ArrayList<>();
+        int[] placedPiece = new int[8];
+        String hint = null;
+
+        // Get the solution and put the piece and their symmetrical piece in the HashSet
+        for (int i = 0; i < 8; i++){
+            correctPiecesSet.add(solution.substring(4 * i, 4 * i + 4));
+            symmetricalPieces = getSymmetricalPieces(solution.substring(4 * i, 4 * i + 4));
+            for (String s : symmetricalPieces) {
+                temp.add(s);
+            }
+        }
+
+        for (String s : temp) {
+            correctPiecesSet.add(s);
+        }
+
+        // Check whether the piece placed on the board is right
+        for (int i = 0; i < placement.length() / 4; i++) {
+            String piece = placement.substring(4 * i, 4 * i + 4);
+            if (piece.charAt(0) > 'h') {
+                break;
+            }
+            if (!correctPiecesSet.contains(piece)) {
+                return null;
+            }
+            placedPiece[piece.charAt(0) - 'a'] = 1;
+        }
+
+        // Give the first unplaced piece for hint
+        for (int i = 0; i < 8; i++) {
+            if (placedPiece[i] == 0) {
+                hint = solution.substring(4 * i, 4 * i + 4);
+                break;
+            }
+        }
+
+        return hint;
+
+    }
+
+//    // If there is only one solution
+//    // Get hint, return null means no solution, String is hint for different solutions
+//    public static String getHint(String placement) {
+//        String[] solutions = getSolutions(placement);
+//        int[] placedPieces = new int[8];
+//        List<String> hint = new ArrayList<>();
+//
+//        // Means there is no any solutions from this placement
+//        if (solutions == null) {
+//            return null;
+//        } else {
+//            // Record the placed pieces
+//            for (int i = 0 ; i < placement.length() / 4; i++) {
+//                placedPieces[placement.charAt(4 * i) - 'a'] = 1;
+//            }
+//            // Return hint
+//            for (int i = 0; i < solutions[0].length() / 4; i++) {
+//                if (placedPieces[i] == 1) {
+//                    continue;
+//                } else {
+//                    return solutions[0].substring(4 * i, 4);
+//                }
+//            }
+//            // All pieces are placed, return null;
+//            return null;
+//        }
+//    }
+
+    // Get all the solutions by using this function
+    public static void getFullSolutions(String path) {
+        String[] solutions = getSolutions("");
+        try {
+            writeSolution(path, solutions);
+        } catch (Exception e) {
+            System.out.println(e);
+        }
+    }
+
+
+    // Get dictionary
+    public static void getDictionary(String solutionsPath, String placementsPath) {
+        List<String> solutions = new ArrayList<>();
+        try {
+            solutions = readCSV(solutionsPath);
+        } catch (IOException e) {
+            System.out.println(e);
+        }
+
+        //HashSet<String> duplicatePegPlacements= new HashSet<>();
+        //List<Piece> piecePlacements = new ArrayList<>() = readCSV(path);
+        //List<HashSet<String>> listOfPegPlacements = new ArrayList<>();
+
+        //Step 1 Generate pegPlacements for a piecePlacement[i]
+        //Repeat Steps 2-4 for each pegPlacement[j] generated in Step 1
+        //Step 2 Discard pegPlacement if contained in duplicatePegPlacements and get the next pegPlacement
+        //Step 3 Check if PegPlacement is contained in listOfPegPlacements for all indexs less than i,
+        // if so remove it and add it to duplicatePegPlacements
+        //Step 4 add pegPlacement to listOfPegPlacements[i]
+        //Step 5 Go back to Step 1 with the next piecePlacement
+
+        //List<String> solutions = readCSV(path);
+
+//        // Test data, can be deleted
+//        solutions.add("a1A6b3A1d7B7e1B1f5C2c1D0g4A3h6A0");
+//        solutions.add("a1A6b3A4c1D0d6A3e7C2f1B2h8A1g4B7");
+//        solutions.add("a1A6b3A4c1D0d6A6e6C0f1B2h8B1g4B7");
+//        solutions.add("a1A6b3A4c1D0d7A1e4C0f1B2g5A1h6D0");
+//        solutions.add("a1A6b3A4c1D0e7B0d6C2g4B1f1B2h6A0");
+
+        String pieceString;
+        int row, column, orientation;
+        String[][] allSolutions = getSymmetricalSolutions(solutions);
+        List<String> iPegString, jPegString, kPegString, lPegString, pegString;
+        Map<String, String> pegPlacement = new HashMap<>();
+        Set<String> toRemove = new HashSet<>();
+        Map<String, String> toAdd;
+
+        int count = 1;
+
+        for (String[] solution : allSolutions) {
+            toAdd = new HashMap<>();
+            for (int i = 0; i < 32; i++) {
+                iPegString = new ArrayList<>();
+                jPegString = new ArrayList<>();
+                kPegString = new ArrayList<>();
+                lPegString = new ArrayList<>();
+                for (int j = 0; j < 8; j++) {
+                    pieceString = solution[i].substring(4 * j, 4 * j + 4);
+
+                    Piece piece = new Piece(pieceString);//Piece.getPiece(pieceString.charAt(0));
+                    column = pieceString.charAt(1);
+                    row = pieceString.charAt(2);
+                    orientation = Character.getNumericValue(pieceString.charAt(3));
+
+                    //Create the new piece with specific orientation and get the relative coordinates of the piece
+                    piece.setOrientation(orientation);
+
+                    
+                    // Get the row and column of the pegs
+                    for (int k = 0;k < piece.getLength();k++) {
+
+                        int[] c = piece.getRelativeCoordinate(k);
+
+                        // If c[2] equals to 2, it is a hole, can put a peg in it
+                        if (c[2] == 2) {
+                            // The color will be the same as the piece
+                            switch (piece.getId()) {
+                                case 'a':
+                                case 'b': iPegString.add("i" + (char) (column + c[0]) + (char) (row + c[1]) + "0"); break;
+                                case 'c':
+                                case 'd': jPegString.add("j" + (char) (column + c[0]) + (char) (row + c[1]) + "0"); break;
+                                case 'e':
+                                case 'f': kPegString.add("k" + (char) (column + c[0]) + (char) (row + c[1]) + "0"); break;
+                                case 'g':
+                                case 'h': lPegString.add("l" + (char) (column + c[0]) + (char) (row + c[1]) + "0"); break;
+                            }
+                        }
+                    }
+                }
+                pegString = getCombinations(iPegString, jPegString, kPegString, lPegString);
+                // For every combinations check whether it is existed in the pegPlacement list
+                for (String newPlacement : pegString) {
+                    // Check whether it is on the blacklist
+                    if (toAdd.containsKey(newPlacement)) {
+                        continue;
+                    }
+
+                    if (toRemove.contains(newPlacement)) {
+                        continue;
+                    }
+                    if (pegPlacement.containsKey(newPlacement)) {
+                        toRemove.add(newPlacement);
+                        continue;
+                    }
+                    toAdd.put(newPlacement, solution[i]);
+                }
+            }
+            // Remove
+            for (String duplicate : toRemove) {
+                pegPlacement.remove(duplicate);
+            }
+            // Add
+            for (Map.Entry<String, String> entry : toAdd.entrySet()) {
+                pegPlacement.put(entry.getKey(), entry.getValue());
+            }
+
+            System.out.println("No." + count++);
+            System.out.println("pegPlacement : " + pegPlacement.size());
+            System.out.println("Add : " + toAdd.size());
+            System.out.println("Remove : " + toRemove.size());
+        }
+
+        
+//        for (String[] s : pegPlacement) {
+//            System.out.println("placement : " + s[0] + "  solutions : " + s[1]);
+//        }
+        System.out.println(pegPlacement.size());
+
+        try {
+            writePlacement(placementsPath, pegPlacement);
+        } catch (IOException e) {
+            System.out.println(e);
+        }
+
+    }
+
+    public static List<String> readCSV(String path) throws IOException {
+        List<String> list = new ArrayList<>();
+        FileReader fr = new FileReader(path);
+        BufferedReader br = new BufferedReader(fr);
+        String line;
+
+        while((line = br.readLine()) != null) {
+            list.add(line);
+        }
+        br.close();
+
+        return list;
+    }
+
+    public static void writeSolution(String path, String[] solutions) throws IOException {
+        PrintWriter pw = new PrintWriter(new File(path));
+        StringBuilder sb = new StringBuilder();
+        for (String solution : solutions) {
+            sb.append(solution);
+            sb.append('\n');
+        }
+        pw.write(sb.toString());
+        pw.close();
+    }
+
+    public static void writePlacement(String path, Map<String, String> placement) throws IOException {
+        PrintWriter pw = new PrintWriter(new File(path));
+        StringBuilder sb = new StringBuilder();
+        for (Map.Entry<String, String> entry: placement.entrySet()) {
+            sb.append(entry.getKey() + " " + entry.getValue());
+            sb.append('\n');
+            pw.write(sb.toString());
+            sb.setLength(0);
+        }
+        pw.close();
+    }
+
+    // Get the symmetrical solutions
+    public static String[][] getSymmetricalSolutions(List<String> solutions) {
+        String switchs, placement, originalPlacement;
+        int[] subString = new int[]{4, 8, 16, 20, 28};
+        String[][] symmetricalSolutions = new String[5992][32];
+
+        for (int i = 0; i < solutions.size(); i++) {
+            originalPlacement = solutions.get(i);
+            for (int j = 0; j < 32; j++) {
+                // a piece stay unflipped
+                placement = originalPlacement.substring(0, 4);
+                switchs = String.format("%5s", Integer.toString(j, 2));
+                for (int k = 0; k < 5; k++) {
+                    if (switchs.charAt(k) == '1') {
+                        placement += getSymmetricalPiece(originalPlacement.substring(subString[k], subString[k] + 4));
+                    } else {
+                        placement += originalPlacement.substring(subString[k], subString[k] + 4);
+                    }
+                }
+                placement = placement.substring(0, 12) + originalPlacement.substring(12, 16) + placement.substring(12, 20) + originalPlacement.substring(24, 28) + placement.substring(20, 24);
+                symmetricalSolutions[i][j] = placement;
+            }
+        }
+
+        return symmetricalSolutions;
+    }
+
+    public static String getSymmetricalPiece(String piece) {
+        if (piece.charAt(0) == 'b' || piece.charAt(0) == 'c' || piece.charAt(0) == 'h') {
+            return piece.substring(0, 3) + (char) (piece.charAt(3) + 2);
+        } else if (piece.charAt(0) == 'e') {
+            if ((piece.charAt(3) == '0')) {
+                return piece.substring(0, 3) + (piece.charAt(3) - '0' + 7);
+            } else {
+                return piece.substring(0, 3) + (piece.charAt(3) - '0' + 3);
+            }
+        } else if (piece.charAt(0) == 'f') {
+            if ((piece.charAt(3) == '0' || piece.charAt(3) == '1')) {
+                return piece.substring(0, 3) + (piece.charAt(3) - '0' + 6);
+            } else {
+                return piece.substring(0, 3) + (piece.charAt(3) - '0' + 2);
+            }
+        } else {
+            return piece;
+        }
+    }
+
+    // Need this to return strong symmetrical piece for getHint function
+    public static String[] getSymmetricalPieces(String piece) {
+        if (piece.charAt(0) == 'b' || piece.charAt(0) == 'c' || piece.charAt(0) == 'h') {
+            return new String[] {piece.substring(0, 3) + (char) (piece.charAt(3) + 2), piece.substring(0, 3) + (char) (piece.charAt(3) + 6)};
+        } else if (piece.charAt(0) == 'e') {
+            if ((piece.charAt(3) == '0')) {
+                return new String[] {piece.substring(0, 3) + (piece.charAt(3) - '0' + 7)};
+            } else {
+                return new String[] {piece.substring(0, 3) + (piece.charAt(3) - '0' + 3)};
+            }
+        } else if (piece.charAt(0) == 'f') {
+            if ((piece.charAt(3) == '0' || piece.charAt(3) == '1')) {
+                return new String[] {piece.substring(0, 3) + (piece.charAt(3) - '0' + 6)};
+            } else {
+                return new String[] {piece.substring(0, 3) + (piece.charAt(3) - '0' + 2)};
+            }
+        } else {
+            return new String[] {piece};
+        }
+    }
+
+    // Get combinations of the pegs
+    public static List<String> getCombinations(List<String> iPegString, List<String> jPegString , List<String> kPegString, List<String> lPegString) {
+        String iPeg, jPeg, kPeg, lPeg;
+        List<String> combinations = new ArrayList<>();
+        List<String> jPegList = getTwoPegs(jPegString);
+        List<String> kPegList = getTwoPegs(kPegString);
+        List<String> lPegList = getTwoPegs(lPegString);
+
+        // Starting with -1, because one or more kind of pegs can be missing
+        for (int i = -1; i < iPegString.size(); i++) {
+            if (i == -1) {
+                iPeg = "";
+            } else {
+                iPeg = iPegString.get(i);
+            }
+            for (int j = -1; j < jPegList.size(); j++) {
+                if (j == -1) {
+                    jPeg = "";
+                } else {
+                    jPeg = jPegList.get(j);
+                }
+                for (int k = -1; k < kPegList.size(); k++) {
+                    if (k == -1) {
+                        kPeg = "";
+                    } else {
+                        kPeg = kPegList.get(k);
+                    }
+                    for (int l = -1; l < lPegList.size(); l++) {
+                        if (l == -1) {
+                            lPeg = "";
+                        } else {
+                            lPeg = lPegList.get(l);
+                        }
+                        if((iPeg + jPeg + kPeg + lPeg).length() == 12){
+                            combinations.add(iPeg + jPeg + kPeg + lPeg);
+                        }
+                    }
+                }
+            }
+        }
+        return combinations;
+    }
+
+    public static List<String> getTwoPegs(List<String> pegString) {
+        String firstPeg, secondPeg;
+        List<String> pegList = new ArrayList<>();
+        Collections.sort(pegString);
+
+        // Combinations of two j pegs
+        // i start with -1, can be nothing for one of the pegs
+        for (int i = -1; i < pegString.size(); i++) {
+            for (int j = i + 1; j < pegString.size(); j++) {
+                if (i == -1) {
+                    firstPeg = "";
+                } else {
+                    firstPeg = pegString.get(i);
+                }
+                if (j == -1) {
+                    secondPeg = "";
+                } else {
+                    secondPeg = pegString.get(j);
+                }
+                pegList.add(firstPeg + secondPeg);
+            }
+        }
+        return pegList;
+    }
+
+    // Since the dictionary we got is all possible placement and solutions
+    // We can further optimize it by getting the minimal subset of the placement
+    // So that we could add any pegs on that placement to form a new placement with unique solution(they are the same)
+    // In this way we can reduce the size of the dictionary
+    // Otherwise, we will have 1.5GB csv file of placement-solution data
+
+    // Tried to do, but it is tricky, finally we decided to get three pegs placement as the "minimal subset"
+
+    // If the placements and solutions file are missing
+    // Run the main function of TwistGame
+    public static void main(String[] args) {
+        String solutionsPath = (System.getProperty("user.dir")) + "/src/comp1110/ass2/Solutions.csv";
+        String placementsPath = (System.getProperty("user.dir")) + "/src/comp1110/ass2/Placement.csv";
+
+        getFullSolutions(solutionsPath);
+        getDictionary(solutionsPath, placementsPath);
+    }
 }
+
+
Only in comp1110-ass2/src/comp1110/ass2: Waldo.class
Only in comp1110-ass2/src/comp1110/ass2: Waldo.java
Only in comp1110-ass2/src/comp1110/ass2/gui: Board$1.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Board$2.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Board$3.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Board$4.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Board.class
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/gui/Board.java comp1110-ass2/src/comp1110/ass2/gui/Board.java
--- ../master/comp1110-ass2/src/comp1110/ass2/gui/Board.java	2018-10-19 19:04:21.542580509 +1100
+++ comp1110-ass2/src/comp1110/ass2/gui/Board.java	2018-10-19 19:32:10.909577441 +1100
@@ -1,22 +1,773 @@
+/*
+Written by James Frampton Reid (u6079329) and Lachlan
+*/
+
 package comp1110.ass2.gui;
 
+import comp1110.ass2.*;
+import comp1110.ass2.Waldo;
+import javafx.animation.KeyFrame;
+import javafx.animation.KeyValue;
+import javafx.animation.Timeline;
 import javafx.application.Application;
+import javafx.event.ActionEvent;
+import javafx.event.EventHandler;
+import javafx.scene.Cursor;
+import javafx.scene.Group;
+import javafx.scene.Node;
+import javafx.scene.Scene;
+import javafx.scene.control.Button;
+import javafx.scene.control.Label;
+import javafx.scene.image.Image;
+import javafx.scene.image.ImageView;
+import javafx.scene.input.KeyCode;
+import javafx.scene.input.KeyEvent;
+import javafx.scene.input.MouseEvent;
+import javafx.scene.layout.Background;
+import javafx.scene.layout.BackgroundImage;
+import javafx.scene.layout.GridPane;
+import javafx.scene.layout.StackPane;
+import javafx.scene.paint.Color;
+import javafx.scene.shape.Polygon;
+import javafx.scene.shape.Rectangle;
+import javafx.scene.text.Font;
+import javafx.scene.text.FontWeight;
+import javafx.scene.text.Text;
+import javafx.scene.transform.Rotate;
 import javafx.stage.Stage;
+import javafx.scene.shape.Line;
+import javafx.util.Duration;
+
+import java.awt.*;
+import java.awt.event.InputEvent;
+import java.net.URL;
+import comp1110.ass2.Objective;
+
+import java.util.Random;
 
+//Authors: u6079329, u6496312
 public class Board extends Application {
+
+    public static final int RIGHT_MARGIN = 10;
+    public static final int TOP_MARGIN = 10;
+
     private static final int BOARD_WIDTH = 933;
     private static final int BOARD_HEIGHT = 700;
+    public static final int SQUARE_SIZE = 70;
+
+    private boolean isHintShown = false;
+
+    public static final char[] PIECE_IDS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
+    public static final double[][] INTIAL_STARTS = {{0,4,0}, {0, 5,0}, {5, 4,0}, {6, 5,0}, {3, 4,0}, {5, 5,0}, {9, 5,0}, {9, 8,0}};
+    public static final int[][] INTIAL_DIMENSIONS = {{2, 3}, {2, 3}, {1, 4}, {2, 3}, {2, 2}, {2, 3}, {3, 3}, {1, 3}, {3, 3}, {1, 3}};
+
+
+    public static String boardState = "";
+
+    public static Objective currentObjective;
+
+    private final Group root = new Group();
+    //Contains all the PieceViews
+    public static Group pieces = new Group();
+    //Group for the lines that mark the board
+    private final Group lines = new Group();
+
+    private final Group pegs = new Group();
+    private final Group newBox = new Group();
+
+    private Group messages = new Group();
+
+    private Text hintText = new Text();
+
+    public static Text victory = new Text();
+
+    private ImageView hintView;
+
+    public static PieceView selectedPiece;
+
+    double xy[] = {75, 25};
+
+
+
+// made obsolete by waldo -u6406312
+@Deprecated
+    public Image tetris(String pieceID, int width, int height) {
+        String zed = pieceID;
+        Image retur = new Image("comp1110/ass2/gui/assets/" + pieceID + ".png", width, height, false, false);
+        return retur;
+    }
+    //("comp1110/ass2/gui/assets/"+pieceId+".png",width,height,false,false)
+    private double[] relativeMouseClick = new double[2];
+
+    // this this is difficulty  TASK 8
+    @Deprecated
+    public static String difficulty(String Difficulty, int insertRandom) {
+        String output;
+        if (Difficulty == "Easy") {
+            if (insertRandom == 0) {
+                return "i1A0" + "j7D0" + "j8D0" + "k4A0" + "k5C0" + "l2D0" + "l8A0"; // this is problem 22 from the manual
+            }
+            if (insertRandom == 1) {
+                return "i3B0" + "j2C0" + "j6B0" + "k1B0" + "k2B0" + "l1D0" + "l6C0"; // this is problem 23 from the manual
+            }
+            if (insertRandom == 2) {
+                return "l1A0" + "i2A0" + "k6A0" + "k6B0" + "j6D0" + "j7C0" + "l6C0"; // this is problem 24 from the manual
+            }
+        }
+        if (Difficulty == "Medium") {
+            if (insertRandom == 0) {
+                return "j3B0" + "j5C0"; // this is problem 49 from the manual
+            }
+            if (insertRandom == 1) {
+                return "k3D0" + "k5D0" + "l3A0" + "l5A0"; // this is problem 79 from the manual
+            }
+            if (insertRandom == 2) {
+                return "i4C0" + "j5B0" + "j7B0"; // this is problem 82 from the manual
+            }
+        }
+        if (Difficulty == "Hard") {
+            if (insertRandom == 0) {
+                return "i7C0" + "j5B0" + "k5D0" + "l3C0"; // this is problem 112 from the manual
+            }
+            if (insertRandom == 1) {
+                return "j5C0" + "k5b0" + "k5d0"; // this is problem 119 from the manual
+            }
+            if (insertRandom == 2) {
+                return "j5B0" + "k4C0" + "k6A0"; // this is problem 105 from the manual
+            }
+        }
+        return "";
+    }
+
+    public static String getPieciesOnBoard () {
+        String board = "";
+        int x = 0;
+
+        while (x < boardState.length()){
+            if        (boardState.charAt(x) != 'i'
+                    && boardState.charAt(x) != 'j'
+                    && boardState.charAt(x) != 'k'
+                    && boardState.charAt(x) != 'l') {board = board+ boardState.charAt(x);
+            x+=4;}
+            else {x+=4;}
+
+        }
+
+        return board;
+    }
+
+    //resets the pieces back to original states
+    void resetPieces(){
+        for(Node node : pieces.getChildren()){
+
+            PieceView pieceView = (PieceView) node;
+
+            pieceView.resetPiece();
+
+        }
+    }
+    //Places Pegs at beginning of the game James
+    void makePegPlacement(String placement) {
+
+        //Initialise the gameState, should only be done at beginning of the game
+        boardState = placement;
+
+        pegs.getChildren().clear();
+
+        resetPieces();
+
+        //loop through pegs and place them
+        for (int i = 0; i < placement.length(); i = i + 4) {
+
+            //get the 4 character substring at i
+            String pegPlacement = placement.substring(i, i + 4);
+
+
 
-    // FIXME Task 7: Implement a basic playable Twist Game in JavaFX that only allows pieces to be placed in valid places
+            //get peg id from placement string and get corresponding image and set to imageView in pegs group
+            char pegId = pegPlacement.charAt(0);
 
-    // FIXME Task 8: Implement starting placements
+            //Adjest peg to SQUARD_SIZE
+            Image pegImage = new Image("comp1110/ass2/gui/assets/" + pegId + ".png", (double) SQUARE_SIZE, (double) SQUARE_SIZE, false, false);
+            ImageView pegView = new ImageView(pegImage);
+            pegs.getChildren().add(pegView);
 
-    // FIXME Task 10: Implement hints
+            //get the row and column and set peg to that row and column
+            int column = Character.getNumericValue(pegPlacement.charAt(1)) - 1;
+            int row = (pegPlacement.charAt(2)) - 'A';
 
-    // FIXME Task 11: Generate interesting starting placements
+            pegView.setX(SQUARE_SIZE * column + RIGHT_MARGIN);
+            pegView.setY(SQUARE_SIZE * row + TOP_MARGIN);
+        }
+
+
+    }
+
+    void makeHintPiecePlacement(String piecePlacement){
+
+        int index = 0;
+        char pieceId = piecePlacement.charAt(0);
+
+        while(pieceId != PIECE_IDS[index]){
+            index++;
+        }
+
+        int height = INTIAL_DIMENSIONS[index][0];
+        int width = INTIAL_DIMENSIONS[index][1];
+
+        //get the piece resized to suit the board
+        Image pieceIamge = new Image("comp1110/ass2/gui/assets/" + pieceId + ".png", SQUARE_SIZE * width, SQUARE_SIZE * height, true, false);
+
+        //set the the image to an imageView
+        hintView = new ImageView();
+        hintView.setImage(pieceIamge);
+        //Set the x y coord
+        hintView.setX(0);
+        hintView.setY(0);
+        //get numeric values for column and row from string
+        int column = Character.getNumericValue(piecePlacement.charAt(1)) - 1;
+        int row = (piecePlacement.charAt(2)) - 'A';
+
+        //place the piece
+        hintView.setX(hintView.getX() + (SQUARE_SIZE * column) + RIGHT_MARGIN);
+        hintView.setY(hintView.getY() + (SQUARE_SIZE * row) + TOP_MARGIN);
+
+        hintView.setOpacity(0.5);
+
+        //parses the orientation into an int
+        int orientation = Character.getNumericValue(piecePlacement.charAt(3));
+
+        rotateAndFlip(hintView,orientation);
+
+        root.getChildren().add(hintView);
+
+
+    }
+
+    @Deprecated
+    void findSnapTo(ImageView pieceView) {
+
+        int xSnap = -1000;
+        int ySnap = -1000;
+
+        double checkLength = SQUARE_SIZE / 2;
+
+        for (int i = 0; i <= 7; i++) {
+
+            double xLine = (i * SQUARE_SIZE - pieceView.getX());
+
+            if (xLine <= checkLength && xLine >= -checkLength) {
+                xSnap = i * SQUARE_SIZE;
+                break;
+            }
+
+        }
+
+        for (int i = 0; i <= 3; i++) {
+
+            double yLine = (i * SQUARE_SIZE - pieceView.getY());
+
+            if (yLine <= checkLength && yLine >= -checkLength) {
+                ySnap = i * SQUARE_SIZE;
+                break;
+            }
+
+
+        }
+
+        pieceView.setX(xSnap);
+        pieceView.setY(ySnap);
+
+    }
+
+    //Take image and rotate it depending on orientation
+
+    void rotateAndFlip(ImageView pieceView, int orientation) {
+
+        //flip the piece over if needed
+        if (orientation > 3) {
+            pieceView.setScaleY(-1);
+            orientation = orientation - 4;
+        }
+        pieceView.setRotate(90 * orientation);
+
+        //correct x y positioning due to orientation change, this assumes that all pieces fit in a rectangle
+        if (orientation % 2 != 0) {
+
+            //float adjust = (float)SQUARE_SIZE / 100;
+
+            double width = (pieceView.getImage().getWidth());// * adjust;
+            double height = pieceView.getImage().getHeight();// * adjust;
+            double correction = (height - width) / 2;
+
+            pieceView.setX(pieceView.getX() + correction);
+            pieceView.setY(pieceView.getY() - correction);
+        }
+    }
+
+
+    //Adds Lines to board to mark where pieces are played James
+    private void makeLines() {
+
+        //loop through all columns and add a new line
+        for (int i = 0; i <= 8; i++) {
+
+            Line boardLine = new Line();
+            boardLine.setStartY(TOP_MARGIN);
+            boardLine.setStartX(i * SQUARE_SIZE + RIGHT_MARGIN);
+            boardLine.setEndY(4 * SQUARE_SIZE + TOP_MARGIN);
+            boardLine.setEndX(i * SQUARE_SIZE + RIGHT_MARGIN);
+            lines.getChildren().add(boardLine);
+        }
+
+        //loop through all rows and add a new line
+        for (int i = 0; i <= 4; i++) {
+
+            Line boardLine = new Line();
+            boardLine.setStartY(i * SQUARE_SIZE + TOP_MARGIN);
+            boardLine.setStartX(RIGHT_MARGIN);
+            boardLine.setEndY(i * SQUARE_SIZE + TOP_MARGIN);
+            boardLine.setEndX(8 * SQUARE_SIZE + RIGHT_MARGIN);
+            lines.getChildren().add(boardLine);
+        }
+    }
+
+    //Puts pieces in starting positions at beginning of the game James
+    private void makePieces() {
+
+        //loop through pieces and place them in the locations using the PieceView class
+        for (int i = 0; i < INTIAL_STARTS.length; i++) {
+
+            char pieceId = PIECE_IDS[i];
+            //Use square size to adjust size of pieces
+            double startX = INTIAL_STARTS[i][0] * SQUARE_SIZE;
+            double startY = INTIAL_STARTS[i][1] * SQUARE_SIZE;
+            double height = INTIAL_DIMENSIONS[i][0] * SQUARE_SIZE;
+            double width = INTIAL_DIMENSIONS[i][1] * SQUARE_SIZE;
+            int orientation = (int) INTIAL_STARTS[i][2];
+
+            Image pieceImg = new Image("comp1110/ass2/gui/assets/" + pieceId + ".png", width, height, false, false);
+
+            PieceView pieceView = new PieceView(pieceImg, pieceId, startX + RIGHT_MARGIN, startY + TOP_MARGIN, height, width,orientation);
+
+            pieces.getChildren().add(pieceView);
+
+        }
+    }
+
+    private void keyPress(KeyEvent event){
+
+        if(isHintShown == false && event.getCode() == KeyCode.SLASH){
+
+
+            if(!(currentObjective == null)) {
+
+
+                String hintPlacement = TwistGame.getHint(boardState, currentObjective);
+
+
+                if (hintPlacement != null) {
+
+                    isHintShown = true;
+
+                    makeHintPiecePlacement(hintPlacement);
+                } else if(hintText.getText().length() == 0){
+
+                    hintText.setText("No hints found try removing some pieces!");
+
+                }
+            }
+        }
+
+        if (selectedPiece != null){
+
+
+            boolean isEven = selectedPiece.getOrientation() % 2 == 0 ? true : false;
+
+            //int to take value 0 if unflipped ie orientation less than 4, and 4 if flipped
+            int isFlipped = (selectedPiece.getOrientation() < 4) ? 0 : 4;
+
+            //take the remainder after dividing by four newOrientation -> 0,1,2,3
+            int newOrientation = selectedPiece.getOrientation() % 4;
+
+            switch (event.getCode()){
+                case UP:
+                    newOrientation = (newOrientation + (isEven ? 0 : 2)) % 4;
+                    isFlipped = ((isFlipped == 0) ? 4 : 0);
+                    break;
+                case DOWN:
+                    newOrientation = (newOrientation + (isEven ? 0 : 2)) % 4;
+                    isFlipped = (isFlipped == 0) ? 4 : 0;
+                    break;
+                case RIGHT:
+                    newOrientation = (newOrientation + 1) % 4;
+                    break;
+                case LEFT:
+                    //decrease the newOrientation by 1
+                    //Math.floorMod is used becasue the value could be negative
+                    newOrientation = Math.floorMod(newOrientation - 1, 4);
+                    break;
+
+            }
+            //add isFlipped to newOrientation and set it to the piece
+            selectedPiece.setOrientation(newOrientation + isFlipped);
+        }
+    }
+
+
+    public void startNewGame(int difficulty){
+
+        Objective objective = Objective.getObjectiveForDifficulty(difficulty);
+
+        currentObjective = objective;
+
+        victory.setText("");
+
+        boardState = objective.getPegPlacement();
+        makePegPlacement(boardState);
+
+        for(Node node :  pieces.getChildren()){
+            PieceView piece = (PieceView) node;
+            piece.resetPiece();
+        }
+
+
+
+    }
 
     @Override
     public void start(Stage primaryStage) throws Exception {
+        Image backdrop = new Image("comp1110/ass2/gui/assets/leaves-and-petals-on-wooden-tabletop_23-2147694457.jpg");
+        ImageView background = new ImageView(backdrop);
+        Rectangle gameBoard = new Rectangle(70*8, 70*4);
+        gameBoard.setY(TOP_MARGIN);
+        gameBoard.setX(RIGHT_MARGIN);
+        gameBoard.setFill(Color.NAVAJOWHITE);
+        primaryStage.setTitle("TwistGame Viewer");
+        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);
+
+        Objective.readObjectives();
+
+
+// victory is lachlan
+        victory.setX(20);
+        victory.setY(450);
+        victory.setFill(Color.GREEN);
+        victory.setFont(Font.font("Tahoma", FontWeight.BOLD ,100));
+
+        //victory.setText("VICTORY");
+
+        messages.getChildren().add(hintText);
+        messages.getChildren().add(victory);
+
+        hintText.setX(10);
+        hintText.setY(350);
+        hintText.setFill(Color.RED);
+        hintText.setFont(Font.font("Tahoma", FontWeight.BOLD ,20));
+        root.getChildren().addAll(background);
+        root.getChildren().add(gameBoard);
+        root.getChildren().add(lines);
+        root.getChildren().add(pegs);
+        root.getChildren().add(pieces);
+        root.getChildren().add(messages);
+
+        makeLines();
+        //makePieces();
+
+        makePegPlacement(boardState);
+
+        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
+            @Override
+            public void handle(KeyEvent event) {
+
+                keyPress(event);
+            }
+        });
+
+        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
+            @Override
+
+            public void handle(KeyEvent event) {
+
+                if(event.getCode() == KeyCode.SLASH){
+
+                    hintText.setText("");
+
+                    if(isHintShown == true){
+
+                        isHintShown = false;
+                        hintView.setImage(null);
+                    }
+                }
+            }
+        });
+// from here on out it lachlans stuff - u6406312
+        //UIelements--box1
+        Rectangle tutorialBox = new Rectangle(580, 10, 250, 325);
+        tutorialBox.setFill(Color.ANTIQUEWHITE);
+        tutorialBox.toBack();
+        root.getChildren().add(tutorialBox);
+        //UIelements--text1
+        javafx.scene.text.Text tut = new javafx.scene.text.Text("Select Piece");
+        tut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
+        tut.setFill(Color.BLACK);
+        tut.setX(630);
+        tut.setY(50);
+        root.getChildren().add(tut);
+
+        //UIelements--text2
+        javafx.scene.text.Text diff = new javafx.scene.text.Text("Easy    Medium    Hard");
+        diff.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
+        diff.setFill(Color.BLACK);
+        diff.setX(600);
+        diff.setY(300);
+        root.getChildren().add(diff);
+
+        //UI text 3
+        Text whatisDifficulty = new Text("Select difficulty to start:");
+        whatisDifficulty.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
+        whatisDifficulty.setX(600);
+        whatisDifficulty.setY(270);
+        root.getChildren().add(whatisDifficulty);
+
+//UIelements--forwardarrow
+        Polygon fwd = new Polygon(750+15, 120, 750+15, 150, 800+15, 135);
+        fwd.setFill(Color.RED);
+        root.getChildren().add(fwd);
+        //UIelements--forwardarrow
+        Polygon back = new Polygon(630+10, 120, 630+10, 150, 580+10, 135);
+        back.setFill(Color.RED);
+        root.getChildren().add(back);
+
+        //UIelements--select
+        ImageView sillyString = new ImageView();
+        sillyString.setImage(Waldo.waldo(0));
+        sillyString.setX(650);
+        sillyString.setY(150);
+        sillyString.toFront();
+        pieces.toFront();
+        // Image selector
+        fwd.setOnMouseClicked(event -> {sillyString.setImage(Waldo.waldoFWD(Waldo.ImageAnal(sillyString.getImage())));
+        sillyString.setOpacity(100);});
+        back.setOnMouseClicked(event -> {sillyString.setImage(Waldo.waldoBCK(Waldo.ImageAnal(sillyString.getImage())));
+        sillyString.setOpacity(100);});
+        // end shame
+        root.getChildren().add(sillyString);
+        // click on sillyString
+        sillyString.setOnMousePressed(event -> { if (sillyString.getOpacity() != 0.0) {
+            pieces.getChildren().add(new PieceView( // currently @root because it brings to frontmak
+                    Waldo.changeDimension(sillyString.getImage()), // Piece Image
+                    Waldo.ImageAnal_String(sillyString.getImage()),  // PieceId
+                    630,  // Initial X
+                    110, // Initial y
+                    2,
+                    3));
+            sillyString.setOpacity(0);
+        }
+        // makes it to difficult to click :(
+        //sillyString.setOnMouseEntered(event1 -> scene.setCursor(Cursor.HAND));
+        //sillyString.setOnMouseExited(event1 -> scene.setCursor(Cursor.DEFAULT));
+
+        });
+      /*  sillyString.setOnMouseDragged(event -> {  try {
+            Robot waldoBot2 = new Robot();
+            waldoBot2.mouseMove((int) Math.round(event.getSceneY()),(int) Math.round(event.getSceneY()));
+        }
+        catch (AWTException e)
+        {
+            e.printStackTrace();
+        }}); */
+        // UI - Instructions
+        Button informationToPlayer = new Button();
+        informationToPlayer.setText("Instructions");
+        informationToPlayer.setLayoutY(300);
+        informationToPlayer.setLayoutX(20);
+        informationToPlayer.setOnAction(new EventHandler<ActionEvent>() {
+            // The following relates to the new window that pops up from pressing the button
+            @Override
+            public void handle(ActionEvent event) {
+                Label instruct = new Label (
+                        "The game is a puzzle; the objective is to place all eight colored playing pieces\n" +
+                        "onto a board comprising 32 locations (the grid) on which up to seven colored pegs may \n" +
+                        "be arranged.  The player must click and drag the pieces such that they fit together\n" +
+                        "correctly on the board, without overlaps or gaps. Also, each of the pegs must be surrounded\n" +
+                        "by a piece of the same colour, meaning the piece must have a hole in the necessary place.\n" +
+                        "In the photo above, a blue peg on the bottom left is surrounded by a blue piece, with the\n" +
+                        "peg fitting exactly into a hole in the blue piece.  The player will need to place the green,\n" +
+                        "yellow and red pieces so that they fit neatly on the green and red pegs, and to complete the\n" +
+                        "game will need to ensure that all pieces are placed with no overlaps and no gaps.\n\n" +
+                        "Click the piece once to get it pop out, drag it and place it\n" +
+                        "Double click to delete the Piece\n");
+                Group instructPane = new Group();
+                instruct.setLayoutX(50);
+                instruct.setLayoutY(20);
+                // Image for instructions : Sourced from online cause why not;
+                Image sourced = new Image("comp1110/ass2/gui/assets/Instructions.jpg");
+                ImageView source= new ImageView(sourced);
+                source.setX(50);
+                source.setY(145);
+                instructPane.getChildren().add(source);
+                Scene instructScene = new Scene(instructPane,700,650);
+                Stage instructWindow = new Stage();
+                //UI Elements- More Text
+                Text flipL = new Text("Rotate Left ← ");
+                flipL.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
+                flipL.setFill(Color.BLACK);
+                flipL.setX(110);
+                flipL.setY(550);
+                instructPane.getChildren().add(flipL);
+                // UI -Elements Controls
+                Image ArrowKeys = new Image("comp1110/ass2/gui/assets/arrowKeys.png", 200, 200, true, false);
+                ImageView keyLayout = new ImageView();
+                keyLayout.setImage(ArrowKeys);
+                keyLayout.setX(230);
+                keyLayout.setY(450);
+                instructPane.getChildren().add(keyLayout);
+                // UI elements CONTROL:
+                Text control = new Text("Controls:");
+                control.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
+                control.setX(75);
+                control.setY(470);
+                instructPane.getChildren().add(control);
+                // UI ELEMENTS get hint
+                Text hintText = new Text(" ' '  - Get hint");
+                hintText.setY(500);
+                hintText.setX(500);
+                hintText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
+                instructPane.getChildren().add(hintText);
+                // HintKey
+                Image forwardSlash = new Image("comp1110/ass2/gui/assets/computer_key_Forward_Slash.png");
+                ImageView slash = new ImageView(forwardSlash);
+                slash.setFitHeight(50);
+                slash.setFitWidth(50);
+                slash.setY(460);
+                slash.setX(480);
+                instructPane.getChildren().add(slash);
+// ui Elements FlipR
+                Text flipR = new Text("  → Rotate Right ");
+                flipR.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
+                flipR.setFill(Color.BLACK);
+                flipR.setX(420);
+                flipR.setY(550);
+                instructPane.getChildren().add(flipR);
+                // UI elements Flip/\\/
+                Text flipUp = new Text("Flip ↑ ↓ ");
+                flipUp.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
+                flipUp.setFill(Color.BLACK);
+                flipUp.setX(300);
+                flipUp.setY(600);
+                instructPane.getChildren().add(flipUp);
+                instructPane.getChildren().add(instruct);
+                instructWindow.setTitle("Instructions");
+                instructWindow.setScene(instructScene);
+                instructWindow.show();
+
+            }
+        });
+
+        root.getChildren().add(informationToPlayer);
+
+// UI - Difficulty Selecter
+        // rectangle is used later
+        Rectangle time = new Rectangle();
+        time.setY(0);
+        time.setX(0);
+        Random rng = new Random();
+        Rectangle easy = new Rectangle(590+10,310,35,20);
+        easy.setFill(Color.GREEN);
+        Rectangle medium = new Rectangle(670+10,310,35,20);
+        medium.setFill(Color.ORANGE);
+        Rectangle hard = new Rectangle(750+10, 310, 35, 20);
+        hard.setFill(Color.RED);
+
+        easy.setOnMousePressed(event -> {
+            pegs.getChildren().clear();
+            pieces.getChildren().clear();
+            time.setX(0);
+            time.setY(0);
+            time.setWidth(1);
+        });
+        easy.setOnMouseReleased(event -> {
+            Objective obj=  (Objective.getObjectiveForDifficulty(3));
+            currentObjective=obj;
+            makePegPlacement(obj.getPegPlacement());
+        });
+        medium.setOnMouseReleased(event -> {
+            Objective obj=  (Objective.getObjectiveForDifficulty(1));
+            currentObjective=obj;
+            makePegPlacement(obj.getPegPlacement());
+        });
+        medium.setOnMousePressed(event -> {
+            pegs.getChildren().clear();
+            pieces.getChildren().clear();
+            time.setX(0);
+            time.setY(0);
+            time.setWidth(1);
+        });
+        hard.setOnMouseReleased(event -> {
+               Objective obj=  (Objective.getObjectiveForDifficulty(0));
+               currentObjective=obj;
+               makePegPlacement(obj.getPegPlacement());
+        });
+        hard.setOnMousePressed(event -> {
+            pegs.getChildren().clear();
+            pieces.getChildren().clear();
+            time.setX(0);
+            time.setY(0);
+            time.setWidth(1);
+        });
+        root.getChildren().add(easy);
+        root.getChildren().add(medium);
+        root.getChildren().add(hard);
+// UI -element score
+        // The rectangle is used because it can easily be manipulated from the timeline
+
+        root.getChildren().add(time);
+        Text score = new Text();
+        score.setX(610);
+        score.setY(550);
+        score.setText("Time  0:00");
+        score.setFont(Font.font("Tahoma",FontWeight.BOLD,20));
+        root.getChildren().add(score);
+        // Victory
+
+
+
+
+
+// Timeline is used to animate the score
+        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10.0D), (ae) -> {
+            background.setFitWidth(primaryStage.getWidth());
+            background.setFitHeight(primaryStage.getHeight());
+            if (time.getY() == 100) {
+                time.setX(time.getX() + 1);
+                time.setY(0);
+            }
+            // if board is full set colour of score to green and will make pause the timer if all pieces are on board
+            if ("abcdefgh".equals( getPieciesOnBoard())) {
+                score.setFill(Color.GREEN);
+                //victory.setX(20);
+                //victory.setY(450);
+                //victory.setText("YOU WIN!");
+                if (score.getY()%2==0) {victory.setFill(Color.GREEN);}
+
+                else {victory.setFill(Color.RED);}
+            }
+// this sets the counter to resemble a stopwatch
+            if (time.getWidth()==1 && !"abcdefgh".equals( getPieciesOnBoard())) {
+                score.setText("Time  " + (int) Math.round(time.getX()) + ":" + (int) Math.round(time.getY()));
+                time.setY(time.getY() + 1);
+            }
+
+        }));
+        timeline.setCycleCount(-1);
+        timeline.play();
+        // minor quality of life change to set resizable == no
+        primaryStage.setResizable(false);
+        // end lachlan's stuff -u6406312
+        primaryStage.setScene(scene);
+        primaryStage.show();
 
     }
+
 }
Only in comp1110-ass2/src/comp1110/ass2/gui: PieceView$1.class
Only in comp1110-ass2/src/comp1110/ass2/gui: PieceView$2.class
Only in comp1110-ass2/src/comp1110/ass2/gui: PieceView$3.class
Only in comp1110-ass2/src/comp1110/ass2/gui: PieceView$4.class
Only in comp1110-ass2/src/comp1110/ass2/gui: PieceView.class
Only in comp1110-ass2/src/comp1110/ass2/gui: PieceView.java
Only in comp1110-ass2/src/comp1110/ass2/gui: Viewer$1.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Viewer$2.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Viewer$3.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Viewer$4.class
Only in comp1110-ass2/src/comp1110/ass2/gui: Viewer.class
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java comp1110-ass2/src/comp1110/ass2/gui/Viewer.java
--- ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2018-10-19 19:04:21.542580509 +1100
+++ comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2018-10-19 19:32:10.909577441 +1100
@@ -1,5 +1,14 @@
+/*
+Author James Frampton Reid(u6079329)
+*/
+
+
 package comp1110.ass2.gui;
 
+import comp1110.ass2.Peg;
+import comp1110.ass2.Piece;
+import comp1110.ass2.TwistGame;
+import comp1110.ass2.Waldo;
 import javafx.application.Application;
 import javafx.event.ActionEvent;
 import javafx.event.EventHandler;
@@ -8,16 +17,33 @@
 import javafx.scene.control.Button;
 import javafx.scene.control.Label;
 import javafx.scene.control.TextField;
+import javafx.scene.image.Image;
+import javafx.scene.image.ImageView;
+import javafx.scene.input.MouseEvent;
 import javafx.scene.layout.HBox;
+import javafx.scene.paint.Color;
+import javafx.scene.shape.Polygon;
+import javafx.scene.shape.Rectangle;
+import javafx.scene.text.Font;
+import javafx.scene.text.FontWeight;
+import javafx.scene.transform.Rotate;
+import javafx.scene.transform.Transform;
+import javafx.scene.transform.Translate;
 import javafx.stage.Stage;
+import javafx.scene.shape.Shape;
+import javafx.scene.shape.Line;
+
+import javax.xml.soap.Text;
+import java.util.Random;
 
 /**
  * A very simple viewer for piece placements in the twist game.
- *
+ * <p>
  * NOTE: This class is separate from your main game class.  This
  * class does not play a game, it just illustrates various piece
  * placements.
  */
+
 public class Viewer extends Application {
 
     /* board layout */
@@ -29,25 +55,209 @@
 
     private final Group root = new Group();
     private final Group controls = new Group();
+    //new group to contain imageViews for pieces
+    private final Group pieces = new Group();
+    private final Group lines = new Group();
     TextField textField;
 
+    private double[] relativeMouseClick = new double[2];
+
+    // this this is difficulty tests - u6406312
+    public static String difficulty(String Difficulty, int insertRandom) {
+        String output;
+        if (Difficulty == "Easy") {
+            if (insertRandom == 0) {
+                return "a1B5b2C0c5A2d7B7e5B0f1A6g3A7h5D0i1B0j7A0j7B0k1A0k2B0l3B0l4C0";
+            }
+            if (insertRandom == 1) {
+                return "a1B5b2C0c5A2d7B7e5B0f1A6g3A7h5D0i1B0j7A0j7B0k1A0k2B0l3B0l4C0";
+            }
+            if (insertRandom == 2) {
+                return "a1B5b2C0c5A2d7B7e5B0f1A6g3A7h5D0i1B0j7A0j7B0k1A0k2B0l3B0l4C0";
+            }
+        }
+        if (Difficulty == "Medium") {
+            if (insertRandom == 0) {
+            }
+            if (insertRandom == 1) {
+            }
+            if (insertRandom == 2) {
+            }
+        }
+        if (Difficulty == "Hard") {
+            if (insertRandom == 0) {
+            }
+            if (insertRandom == 1) {
+            }
+            if (insertRandom == 2) {
+            }
+        }
+        return "";
+    }
+
 
     /**
      * Draw a placement in the window, removing any previously drawn one
      *
-     * @param placement  A valid placement string
+     * @param placement A valid placement string
      */
     void makePlacement(String placement) {
+
+        //clears pieces currently on the screen
+        pieces.getChildren().clear();
+
+        //loop through every four characters in placement
+        for (int i = 0; i < placement.length() / 4; i++) {
+
+            //get the 4 character substring at i
+            String piecePlacement = placement.substring(i * 4, i * 4 + 4);
+            //place the piece
+            makePiecePlacement(piecePlacement);
+
+        }
+
         // FIXME Task 4: implement the simple placement viewer
     }
 
 
+    void makePiecePlacement(String piecePlacement) {
+
+
+        //get the id of the piece ie 'a' and get the png image
+        char pieceId = piecePlacement.charAt(0);
+        Image pieceImg = new Image("comp1110/ass2/gui/assets/" + pieceId + ".png");
+
+        //get the height of the piece
+        double height = pieceImg.getHeight() / 100;
+        double width = pieceImg.getWidth() / 100;
+
+        //get the piece resized to suit the board
+        pieceImg = new Image("comp1110/ass2/gui/assets/" + pieceId + ".png", SQUARE_SIZE * width, SQUARE_SIZE * height, true, false);
+
+        //set the the image to an imageView
+        ImageView pieceView = new ImageView();
+        pieceView.setImage(pieceImg);
+        //Set the x y coord
+        pieceView.setX(0);
+        pieceView.setY(0);
+        //get numeric values for column and row from string
+        int column = Character.getNumericValue(piecePlacement.charAt(1)) - 1;
+        int row = (piecePlacement.charAt(2)) - 'A';
+
+        //place the piece
+        pieceView.setX(pieceView.getX() + (SQUARE_SIZE * column));
+        pieceView.setY(pieceView.getY() + (SQUARE_SIZE * row));
+
+        //parses the orientation into an int
+        int orientation = Character.getNumericValue(piecePlacement.charAt(3));
+
+        rotateAndFlip(pieceView, orientation);
+
+        //Find where the piece was clicked on and store it
+        pieceView.setOnMousePressed(new EventHandler<MouseEvent>() {
+            @Override
+            public void handle(MouseEvent event) {
+                relativeMouseClick[0] = event.getX() - pieceView.getX();
+                relativeMouseClick[1] = event.getY() - pieceView.getY();
+            }
+        });
+        //Upon release find where it will snap to and determine whether that is a good location or not
+        pieceView.setOnMouseReleased(new EventHandler<MouseEvent>() {
+            @Override
+            public void handle(MouseEvent event) {
+                findSnapTo(pieceView);
+            }
+        });
+
+        //Move piece on drag
+        pieceView.setOnMouseDragged(new EventHandler<MouseEvent>() {
+            @Override
+            public void handle(MouseEvent event) {
+                translatePiece(event, pieceView, relativeMouseClick);
+            }
+        });
+
+        //add the imageView
+        pieces.getChildren().add(pieceView);
+
+    }
+
+    void translatePiece(MouseEvent event, ImageView pieceView, double[] relativePoint) {
+
+        //Move piece to mouse considering where the mouse was clicked inside the piece
+        pieceView.setX(event.getX() - relativePoint[0]);
+        pieceView.setY(event.getY() - relativePoint[1]);
+
+    }
+
+    void findSnapTo(ImageView pieceView) {
+
+        int xSnap = -1000;
+        int ySnap = -1000;
+
+        double checkLength = SQUARE_SIZE / 2;
+
+        for (int i = 0; i <= 7; i++) {
+
+            double xLine = (i * SQUARE_SIZE - pieceView.getX());
+
+            if (xLine <= checkLength && xLine >= -checkLength) {
+                xSnap = i * SQUARE_SIZE;
+                break;
+            }
+
+        }
+
+        for (int i = 0; i <= 3; i++) {
+
+            double yLine = (i * SQUARE_SIZE - pieceView.getY());
+
+            if (yLine <= checkLength && yLine >= -checkLength) {
+                ySnap = i * SQUARE_SIZE;
+                break;
+            }
+
+
+        }
+
+        pieceView.setX(xSnap);
+        pieceView.setY(ySnap);
+
+    }
+
+
+    void rotateAndFlip(ImageView pieceView, int orientation) {
+
+        //flip the piece over if needed
+        if (orientation > 3) {
+            pieceView.setScaleY(-1);
+            orientation = orientation - 4;
+        }
+
+        pieceView.setRotate(90 * orientation);
+
+        //correct x y positioning due to orientation change, this assumes that all pieces fit in a rectangle
+        if (orientation % 2 != 0) {
+
+            //float adjust = (float)SQUARE_SIZE / 100;
+
+            double width = (pieceView.getImage().getWidth());// * adjust;
+            double height = pieceView.getImage().getHeight();// * adjust;
+            double correction = (height - width) / 2;
+
+            pieceView.setX(pieceView.getX() + correction);
+            pieceView.setY(pieceView.getY() - correction);
+        }
+
+
+    }
+
     /**
      * Create a basic text field for input and a refresh button.
      */
     private void makeControls() {
         Label label1 = new Label("Placement:");
-        textField = new TextField ();
+        textField = new TextField();
         textField.setPrefWidth(300);
         Button button = new Button("Refresh");
         button.setOnAction(new EventHandler<ActionEvent>() {
@@ -65,16 +275,55 @@
         controls.getChildren().add(hb);
     }
 
+    private void makeLines() {
+
+        for (int i = 1; i <= 8; i++) {
+
+            Line boardLine = new Line();
+            boardLine.setStartY(0);
+            boardLine.setStartX(i * SQUARE_SIZE);
+            boardLine.setEndY(4 * SQUARE_SIZE);
+            boardLine.setEndX(i * SQUARE_SIZE);
+            lines.getChildren().add(boardLine);
+        }
+
+        for (int i = 1; i <= 4; i++) {
+
+            Line boardLine = new Line();
+            boardLine.setStartY(i * SQUARE_SIZE);
+            boardLine.setStartX(0);
+            boardLine.setEndY(i * SQUARE_SIZE);
+            boardLine.setEndX(8 * SQUARE_SIZE);
+            lines.getChildren().add(boardLine);
+        }
+
+        Line boardLine = new Line();
+        boardLine.setStartX(0);
+        boardLine.setStartY(0);
+
+    }
+
     @Override
     public void start(Stage primaryStage) throws Exception {
         primaryStage.setTitle("TwistGame Viewer");
         Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
 
         root.getChildren().add(controls);
+        root.getChildren().add(pieces);
+        root.getChildren().add(lines);
 
         makeControls();
+        makeLines();
+
+
+        primaryStage.setScene(scene);
+        primaryStage.show();
+
+
+
 
         primaryStage.setScene(scene);
         primaryStage.show();
     }
+
 }
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: Instructions.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: Kursor.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: arrowKeys-300x205.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: arrowKeys.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: computer_key_Forward_Slash.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: leaves-and-petals-on-wooden-tabletop_23-2147694457.jpg
Only in comp1110-ass2/tests/comp1110/ass2: DoesDifficultyWorkTest.java
Only in comp1110-ass2/tests/comp1110/ass2: PieceSetOrientationTest.java
diff -ru -x .git ../master/comp1110-ass2/tests/comp1110/ass2/PlacementStringValidTest.java comp1110-ass2/tests/comp1110/ass2/PlacementStringValidTest.java
--- ../master/comp1110-ass2/tests/comp1110/ass2/PlacementStringValidTest.java	2018-10-19 19:04:21.546580582 +1100
+++ comp1110-ass2/tests/comp1110/ass2/PlacementStringValidTest.java	2018-10-19 19:32:10.917577590 +1100
@@ -18,7 +18,7 @@
  */
 public class PlacementStringValidTest {
   @Rule
-  public Timeout globalTimeout = Timeout.millis(20000);
+  public Timeout globalTimeout = Timeout.millis(2000000);
 
   private void test(String in, String invalid, boolean expected) {
     boolean out = TwistGame.isPlacementStringValid(in);
@@ -81,7 +81,7 @@
   public void badPegs() {
     for (int i = 0; i < GOOD_PLACEMENTS.length; i++) {
       String badpeg = INVALID_PEGS[i%INVALID_PEGS.length];
-      test(GOOD_PLACEMENTS[i], "", true);
+      test("a1B5b2C0c5A2d7B7e5B0f1A6g3A7h5D0i1B0j7A0j7B0k1A0k2B0l3B0l4C0", "", true);
       test(badpeg, badpeg, false);
     }
   }
diff -ru -x .git ../master/comp1110-ass2/tests/comp1110/ass2/SolutionsTest.java comp1110-ass2/tests/comp1110/ass2/SolutionsTest.java
--- ../master/comp1110-ass2/tests/comp1110/ass2/SolutionsTest.java	2018-10-19 19:04:21.546580582 +1100
+++ comp1110-ass2/tests/comp1110/ass2/SolutionsTest.java	2018-10-19 19:32:10.917577590 +1100
@@ -5,6 +5,7 @@
 import org.junit.rules.Timeout;
 
 import java.util.Arrays;
+import java.util.HashSet;
 import java.util.Set;
 import java.util.TreeSet;
 
@@ -31,7 +32,7 @@
   private void single(int n) {
     for (int i = 0; i < GOOD_PLACEMENTS.length; i++) {
       TreeSet<String> expected = new TreeSet<>();
-      expected.add(GOOD_PLACEMENTS[i].substring(0,32));
+      expected.add(GOOD_PLACEMENTS[i].substring(0, 32));
       test(SINGLE[n][i], expected);
     }
   }
diff -ru -x .git ../master/comp1110-ass2/tests/comp1110/ass2/ViablePlacementsTest.java comp1110-ass2/tests/comp1110/ass2/ViablePlacementsTest.java
--- ../master/comp1110-ass2/tests/comp1110/ass2/ViablePlacementsTest.java	2018-10-19 19:04:21.546580582 +1100
+++ comp1110-ass2/tests/comp1110/ass2/ViablePlacementsTest.java	2018-10-19 19:32:10.917577590 +1100
@@ -4,7 +4,6 @@
 import org.junit.Test;
 import org.junit.rules.Timeout;
 
-import java.util.HashSet;
 import java.util.Random;
 import java.util.Set;
 import java.util.TreeSet;
Only in comp1110-ass2/tests/comp1110/ass2: WaldoTest.java
Only in comp1110-ass2/tests/comp1110/ass2: findInsertPositionTest.java
Only in comp1110-ass2/tests/comp1110/ass2: getBoardSituationTest.java
Only in comp1110-ass2/tests/comp1110/ass2: getCombinationTest.java
Only in comp1110-ass2/tests/comp1110/ass2: getPieceSituationTest.java
Only in comp1110-ass2/tests/comp1110/ass2: getSymmetricalPieceTest.java
Only in comp1110-ass2/tests/comp1110/ass2: getSymmetricalSolutionsTest.java
Only in comp1110-ass2/tests/comp1110/ass2: getTwoPegsTest.java
```
## Test log
```
--javac output--
Note: comp1110-ass2/src/comp1110/ass2/TwistGame.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
----
java -cp comp1110-ass2/src:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/ass2-1110-tests.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/hamcrest-core-1.3.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/junit-4.12.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/commons-lang3-3.8.1.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/deploy.jar::/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/jfxrt.jar org.junit.runner.JUnitCore comp1110.ass2.PlacementWellFormedTest
---
JUnit version 4.12
.....
Time: 0.018

OK (5 tests)

java -cp comp1110-ass2/src:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/ass2-1110-tests.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/hamcrest-core-1.3.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/junit-4.12.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/commons-lang3-3.8.1.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/deploy.jar::/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/jfxrt.jar org.junit.runner.JUnitCore comp1110.ass2.PlacementStringWellFormedTest
---
JUnit version 4.12
.....
Time: 0.021

OK (5 tests)

java -cp comp1110-ass2/src:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/ass2-1110-tests.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/hamcrest-core-1.3.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/junit-4.12.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/commons-lang3-3.8.1.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/deploy.jar::/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/jfxrt.jar org.junit.runner.JUnitCore comp1110.ass2.PlacementStringValidTest
---
JUnit version 4.12
.....
Time: 0.03

OK (5 tests)

java -cp comp1110-ass2/src:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/ass2-1110-tests.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/hamcrest-core-1.3.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/junit-4.12.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/commons-lang3-3.8.1.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/deploy.jar::/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/jfxrt.jar org.junit.runner.JUnitCore comp1110.ass2.ViablePlacementsTest
---
JUnit version 4.12
.....
Time: 0.114

OK (5 tests)

java -cp comp1110-ass2/src:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/ass2-1110-tests.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/hamcrest-core-1.3.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/junit-4.12.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/commons-lang3-3.8.1.jar:/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/deploy.jar::/dept/dcs/comp1110/supr/comp1110-tutors/bin/../ass2/jfxrt.jar org.junit.runner.JUnitCore comp1110.ass2.SolutionsTest
---
JUnit version 4.12
.....
Time: 0.174

OK (5 tests)

```
