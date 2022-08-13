package Intermediate.Arrays.twodmetrices;

import java.util.ArrayList;
/*
* Problem Description

You are given a matrix A, you have to return another matrix which is the transpose of A.

NOTE: Transpose of a matrix A is defined as - AT[i][j] = A[j][i] ; Where 1 ≤ i ≤ col and 1 ≤ j ≤ row



Problem Constraints

1 <= A.size() <= 1000

1 <= A[i].size() <= 1000

1 <= A[i][j] <= 1000



Input Format

First argument is vector of vector of integers A representing matrix.



Output Format

You have to return a vector of vector of integers after doing required operations.



Example Input

Input 1:

A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
Input 2:

A = [[1, 2],[1, 2],[1, 2]]


Example Output

Output 1:

[[1, 4, 7], [2, 5, 8], [3, 6, 9]]
Output 2:

[[1, 1, 1], [2, 2, 2]]


Example Explanation

Explanation 1:

Cearly after converting rows to column and columns to rows of [[1, 2, 3],[4, 5, 6],[7, 8, 9]] we will get [[1, 4, 7], [2, 5, 8], [3, 6, 9]].
* */
public class MatrixTranspose {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int i=0; i<A.get(0).size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (ArrayList<Integer> integers : A) {
                row.add(integers.get(i));
            }
            res.add(row);
        }
        return res;
    }
}

/*
* [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 ]
* [316 317 318 319 320 321 322 323 324 325 326 327 328 329 330 331 332 333 334 335 336 337 338 339 340 341 342 343 344 345 346 347 348 349 350 351 352 353 354 355 356 357 358 359 360 361 362 363 364 365 366 367 368 369 370 371 372 373 374 375 376 377 378 379 380 381 382 383 384 385 386 387 388 389 390 391 392 393 394 81 ]
* [315 624 625 626 627 628 629 630 631 632 633 634 635 636 637 638 639 640 641 642 643 644 645 646 647 648 649 650 651 652 653 654 655 656 657 658 659 660 661 662 663 664 665 666 667 668 669 670 671 672 673 674 675 676 677 678 679 680 681 682 683 684 685 686 687 688 689 690 691 692 693 694 695 696 697 698 699 700 395 82 ]
* [314 623 924 925 926 927 928 929 930 931 932 933 934 935 936 937 938 939 940 941 942 943 944 945 946 947 948 949 950 951 952 953 954 955 956 957 958 959 960 961 962 963 964 965 966 967 968 969 970 971 972 973 974 975 976 977 978 979 980 981 982 983 984 985 986 987 988 989 990 991 992 993 994 995 996 997 998 701 396 83 ]
* [313 622 923 1216 1217 1218 1219 1220 1221 1222 1223 1224 1225 1226 1227 1228 1229 1230 1231 1232 1233 1234 1235 1236 1237 1238 1239 1240 1241 1242 1243 1244 1245 1246 1247 1248 1249 1250 1251 1252 1253 1254 1255 1256 1257 1258 1259 1260 1261 1262 1263 1264 1265 1266 1267 1268 1269 1270 1271 1272 1273 1274 1275 1276 1277 1278 1279 1280 1281 1282 1283 1284 1285 1286 1287 1288 999 702 397 84 ]
* [312 621 922 1215 1500 1501 1502 1503 1504 1505 1506 1507 1508 1509 1510 1511 1512 1513 1514 1515 1516 1517 1518 1519 1520 1521 1522 1523 1524 1525 1526 1527 1528 1529 1530 1531 1532 1533 1534 1535 1536 1537 1538 1539 1540 1541 1542 1543 1544 1545 1546 1547 1548 1549 1550 1551 1552 1553 1554 1555 1556 1557 1558 1559 1560 1561 1562 1563 1564 1565 1566 1567 1568 1569 1570 1289 1000 703 398 85 ]
* [311 620 921 1214 1499 1776 1777 1778 1779 1780 1781 1782 1783 1784 1785 1786 1787 1788 1789 1790 1791 1792 1793 1794 1795 1796 1797 1798 1799 1800 1801 1802 1803 1804 1805 1806 1807 1808 1809 1810 1811 1812 1813 1814 1815 1816 1817 1818 1819 1820 1821 1822 1823 1824 1825 1826 1827 1828 1829 1830 1831 1832 1833 1834 1835 1836 1837 1838 1839 1840 1841 1842 1843 1844 1571 1290 1001 704 399 86 ]
* [310 619 920 1213 1498 1775 2044 2045 2046 2047 2048 2049 2050 2051 2052 2053 2054 2055 2056 2057 2058 2059 2060 2061 2062 2063 2064 2065 2066 2067 2068 2069 2070 2071 2072 2073 2074 2075 2076 2077 2078 2079 2080 2081 2082 2083 2084 2085 2086 2087 2088 2089 2090 2091 2092 2093 2094 2095 2096 2097 2098 2099 2100 2101 2102 2103 2104 2105 2106 2107 2108 2109 2110 1845 1572 1291 1002 705 400 87 ]
* [309 618 919 1212 1497 1774 2043 2304 2305 2306 2307 2308 2309 2310 2311 2312 2313 2314 2315 2316 2317 2318 2319 2320 2321 2322 2323 2324 2325 2326 2327 2328 2329 2330 2331 2332 2333 2334 2335 2336 2337 2338 2339 2340 2341 2342 2343 2344 2345 2346 2347 2348 2349 2350 2351 2352 2353 2354 2355 2356 2357 2358 2359 2360 2361 2362 2363 2364 2365 2366 2367 2368 2111 1846 1573 1292 1003 706 401 88 ]
* [308 617 918 1211 1496 1773 2042 2303 2556 2557 2558 2559 2560 2561 2562 2563 2564 2565 2566 2567 2568 2569 2570 2571 2572 2573 2574 2575 2576 2577 2578 2579 2580 2581 2582 2583 2584 2585 2586 2587 2588 2589 2590 2591 2592 2593 2594 2595 2596 2597 2598 2599 2600 2601 2602 2603 2604 2605 2606 2607 2608 2609 2610 2611 2612 2613 2614 2615 2616 2617 2618 2369 2112 1847 1574 1293 1004 707 402 89 ]
* [307 616 917 1210 1495 1772 2041 2302 2555 2800 2801 2802 2803 2804 2805 2806 2807 2808 2809 2810 2811 2812 2813 2814 2815 2816 2817 2818 2819 2820 2821 2822 2823 2824 2825 2826 2827 2828 2829 2830 2831 2832 2833 2834 2835 2836 2837 2838 2839 2840 2841 2842 2843 2844 2845 2846 2847 2848 2849 2850 2851 2852 2853 2854 2855 2856 2857 2858 2859 2860 2619 2370 2113 1848 1575 1294 1005 708 403 90 ]
* [306 615 916 1209 1494 1771 2040 2301 2554 2799 3036 3037 3038 3039 3040 3041 3042 3043 3044 3045 3046 3047 3048 3049 3050 3051 3052 3053 3054 3055 3056 3057 3058 3059 3060 3061 3062 3063 3064 3065 3066 3067 3068 3069 3070 3071 3072 3073 3074 3075 3076 3077 3078 3079 3080 3081 3082 3083 3084 3085 3086 3087 3088 3089 3090 3091 3092 3093 3094 2861 2620 2371 2114 1849 1576 1295 1006 709 404 91 ]
* [305 614 915 1208 1493 1770 2039 2300 2553 2798 3035 3264 3265 3266 3267 3268 3269 3270 3271 3272 3273 3274 3275 3276 3277 3278 3279 3280 3281 3282 3283 3284 3285 3286 3287 3288 3289 3290 3291 3292 3293 3294 3295 3296 3297 3298 3299 3300 3301 3302 3303 3304 3305 3306 3307 3308 3309 3310 3311 3312 3313 3314 3315 3316 3317 3318 3319 3320 3095 2862 2621 2372 2115 1850 1577 1296 1007 710 405 92 ]
* [304 613 914 1207 1492 1769 2038 2299 2552 2797 3034 3263 3484 3485 3486 3487 3488 3489 3490 3491 3492 3493 3494 3495 3496 3497 3498 3499 3500 3501 3502 3503 3504 3505 3506 3507 3508 3509 3510 3511 3512 3513 3514 3515 3516 3517 3518 3519 3520 3521 3522 3523 3524 3525 3526 3527 3528 3529 3530 3531 3532 3533 3534 3535 3536 3537 3538 3321 3096 2863 2622 2373 2116 1851 1578 1297 1008 711 406 93 ]
* [303 612 913 1206 1491 1768 2037 2298 2551 2796 3033 3262 3483 3696 3697 3698 3699 3700 3701 3702 3703 3704 3705 3706 3707 3708 3709 3710 3711 3712 3713 3714 3715 3716 3717 3718 3719 3720 3721 3722 3723 3724 3725 3726 3727 3728 3729 3730 3731 3732 3733 3734 3735 3736 3737 3738 3739 3740 3741 3742 3743 3744 3745 3746 3747 3748 3539 3322 3097 2864 2623 2374 2117 1852 1579 1298 1009 712 407 94 ]
* [302 611 912 1205 1490 1767 2036 2297 2550 2795 3032 3261 3482 3695 3900 3901 3902 3903 3904 3905 3906 3907 3908 3909 3910 3911 3912 3913 3914 3915 3916 3917 3918 3919 3920 3921 3922 3923 3924 3925 3926 3927 3928 3929 3930 3931 3932 3933 3934 3935 3936 3937 3938 3939 3940 3941 3942 3943 3944 3945 3946 3947 3948 3949 3950 3749 3540 3323 3098 2865 2624 2375 2118 1853 1580 1299 1010 713 408 95 ]
* [301 610 911 1204 1489 1766 2035 2296 2549 2794 3031 3260 3481 3694 3899 4096 4097 4098 4099 4100 4101 4102 4103 4104 4105 4106 4107 4108 4109 4110 4111 4112 4113 4114 4115 4116 4117 4118 4119 4120 4121 4122 4123 4124 4125 4126 4127 4128 4129 4130 4131 4132 4133 4134 4135 4136 4137 4138 4139 4140 4141 4142 4143 4144 3951 3750 3541 3324 3099 2866 2625 2376 2119 1854 1581 1300 1011 714 409 96 ]
* [300 609 910 1203 1488 1765 2034 2295 2548 2793 3030 3259 3480 3693 3898 4095 4284 4285 4286 4287 4288 4289 4290 4291 4292 4293 4294 4295 4296 4297 4298 4299 4300 4301 4302 4303 4304 4305 4306 4307 4308 4309 4310 4311 4312 4313 4314 4315 4316 4317 4318 4319 4320 4321 4322 4323 4324 4325 4326 4327 4328 4329 4330 4145 3952 3751 3542 3325 3100 2867 2626 2377 2120 1855 1582 1301 1012 715 410 97 ]
* [299 608 909 1202 1487 1764 2033 2294 2547 2792 3029 3258 3479 3692 3897 4094 4283 4464 4465 4466 4467 4468 4469 4470 4471 4472 4473 4474 4475 4476 4477 4478 4479 4480 4481 4482 4483 4484 4485 4486 4487 4488 4489 4490 4491 4492 4493 4494 4495 4496 4497 4498 4499 4500 4501 4502 4503 4504 4505 4506 4507 4508 4331 4146 3953 3752 3543 3326 3101 2868 2627 2378 2121 1856 1583 1302 1013 716 411 98 ]
* [298 607 908 1201 1486 1763 2032 2293 2546 2791 3028 3257 3478 3691 3896 4093 4282 4463 4636 4637 4638 4639 4640 4641 4642 4643 4644 4645 4646 4647 4648 4649 4650 4651 4652 4653 4654 4655 4656 4657 4658 4659 4660 4661 4662 4663 4664 4665 4666 4667 4668 4669 4670 4671 4672 4673 4674 4675 4676 4677 4678 4509 4332 4147 3954 3753 3544 3327 3102 2869 2628 2379 2122 1857 1584 1303 1014 717 412 99 ]
* [297 606 907 1200 1485 1762 2031 2292 2545 2790 3027 3256 3477 3690 3895 4092 4281 4462 4635 4800 4801 4802 4803 4804 4805 4806 4807 4808 4809 4810 4811 4812 4813 4814 4815 4816 4817 4818 4819 4820 4821 4822 4823 4824 4825 4826 4827 4828 4829 4830 4831 4832 4833 4834 4835 4836 4837 4838 4839 4840 4679 4510 4333 4148 3955 3754 3545 3328 3103 2870 2629 2380 2123 1858 1585 1304 1015 718 413 100 ]
* [296 605 906 1199 1484 1761 2030 2291 2544 2789 3026 3255 3476 3689 3894 4091 4280 4461 4634 4799 4956 4957 4958 4959 4960 4961 4962 4963 4964 4965 4966 4967 4968 4969 4970 4971 4972 4973 4974 4975 4976 4977 4978 4979 4980 4981 4982 4983 4984 4985 4986 4987 4988 4989 4990 4991 4992 4993 4994 4841 4680 4511 4334 4149 3956 3755 3546 3329 3104 2871 2630 2381 2124 1859 1586 1305 1016 719 414 101 ]
* [295 604 905 1198 1483 1760 2029 2290 2543 2788 3025 3254 3475 3688 3893 4090 4279 4460 4633 4798 4955 5104 5105 5106 5107 5108 5109 5110 5111 5112 5113 5114 5115 5116 5117 5118 5119 5120 5121 5122 5123 5124 5125 5126 5127 5128 5129 5130 5131 5132 5133 5134 5135 5136 5137 5138 5139 5140 4995 4842 4681 4512 4335 4150 3957 3756 3547 3330 3105 2872 2631 2382 2125 1860 1587 1306 1017 720 415 102 ]
* [294 603 904 1197 1482 1759 2028 2289 2542 2787 3024 3253 3474 3687 3892 4089 4278 4459 4632 4797 4954 5103 5244 5245 5246 5247 5248 5249 5250 5251 5252 5253 5254 5255 5256 5257 5258 5259 5260 5261 5262 5263 5264 5265 5266 5267 5268 5269 5270 5271 5272 5273 5274 5275 5276 5277 5278 5141 4996 4843 4682 4513 4336 4151 3958 3757 3548 3331 3106 2873 2632 2383 2126 1861 1588 1307 1018 721 416 103 ]
* [293 602 903 1196 1481 1758 2027 2288 2541 2786 3023 3252 3473 3686 3891 4088 4277 4458 4631 4796 4953 5102 5243 5376 5377 5378 5379 5380 5381 5382 5383 5384 5385 5386 5387 5388 5389 5390 5391 5392 5393 5394 5395 5396 5397 5398 5399 5400 5401 5402 5403 5404 5405 5406 5407 5408 5279 5142 4997 4844 4683 4514 4337 4152 3959 3758 3549 3332 3107 2874 2633 2384 2127 1862 1589 1308 1019 722 417 104 ]
* [292 601 902 1195 1480 1757 2026 2287 2540 2785 3022 3251 3472 3685 3890 4087 4276 4457 4630 4795 4952 5101 5242 5375 5500 5501 5502 5503 5504 5505 5506 5507 5508 5509 5510 5511 5512 5513 5514 5515 5516 5517 5518 5519 5520 5521 5522 5523 5524 5525 5526 5527 5528 5529 5530 5409 5280 5143 4998 4845 4684 4515 4338 4153 3960 3759 3550 3333 3108 2875 2634 2385 2128 1863 1590 1309 1020 723 418 105 ]
* [291 600 901 1194 1479 1756 2025 2286 2539 2784 3021 3250 3471 3684 3889 4086 42...
* */