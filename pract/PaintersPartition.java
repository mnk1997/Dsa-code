package in.cdac.pract;

import java.util.ArrayList;
import java.util.Arrays;

/*Problem Description
Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.

Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.*/
/*Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.

Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
*/
/*Return the ans % 10000003.*/

/*A = 10
B = 1
C = [1, 8, 11, 3]   output 11*/
public class PaintersPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1531,4563,3131,3953,4029,1123,8785,3641,3034,622,1508,3161,2250,6121,2324,5315,7792,8476,344,1752,8040,167,5222,830,471,9939,9233,7995,3706,3572,9789,5236,8134,9271,9188,8514,394,4324,2154,9779,1297,13,2939,3547,6134,1614,5213,3925,6441,1908,2028,4481,2074,7250,1662,2544,3540,894,6891,7246,818,3031,2481,8951,2302,8021,7465,9047,2344,5970,8825,9993,5983,1763,3539,2116,9728,8751,2392,6168,658,771,648,9083,4372,2309,1627,7912,9555,4869,5157,372,7899,7637,5674,200,5657,9490,9246,4353,5460,8070,4345,1442,6184,7883,9909,5911,2985,8652,2079,9994,9422,9078,9076,3794,1387,7054,1705,7293,1922,6861,7664,9821,849,3337,6372,2858,9179,5618,7210,4638,39,7906,2431,2575,5788,8691,8485,5124,7342,6915,5117,6763,2345,544,6908,83,7598,8612,7375,5871,1824,1390,2043,9025,1078,8415,1882,256,384,5443,4893,6774,3348,7323,9348,5487,2365,4185,610,9706,7451,2078,2821,9795,2621,9728,9877,6570,4692,7251,2441,2867,8640,4483,1891,9718,9249,3772,9973,9632,9214,1218,6406,8913,4892,2105,4399,7257,6289,1360,3314,3740,3437,2486,9886,2410,2214,9763,5331,3257,3365,4123,6123,2005,4958,8014,8074,4206,8137,4398,190,3703,1967,2947,2615,6859,5051,3366,467,7692,4725,3780,1431,4514,6266,1316,6923,4831,7430,8605,8087,795,2728,561,9151,7685,4926,7224,8242,3063,7973,8431,3117,9940,1377,5731,3150,2780,5448,3616,471,173,3747,8253,4686,6364,5920,7960,1194,3350,6564,5632,4144,5643,2545,3294,9679,7470,6869,7921,6884,1193,2703,10000,1132,432,2083,633,3211,7530,4248,33,7702,4347,8285,8739,710,4204,3050,8256,7553,5966,3887,8048,1608,2783,7693,7639,253,4561,1911,7136,2106,4613,7136,3237,1396,9218,3870,4606,3099,4469,4638,801,8815,9274,5891,5877,3478,8941,4132,7382,4906,4370,5430,2865,7153,3122,503,7405,4035,2413,892,6140,3378,4379,5728,4773,9948,5949,5731,3047,6770,6720,199,1936,5994,6089,7812,5823,1381,1943,3204,6286,6313,4985,9151,3465,8107,6005,7221,8493,4770,8112,984,8147,2491,3063,9271,8790,9012,1353,1836,2133,4425,2034,4068,6770,8123,1880,2592,9503,174,2147,2141,6486,7132,7643,6302,1590,3647,3522,82,8416,7986,7417,2914,6828,479,2185,5617,5842,9889,7453,7974,4313,5838,8394,1082,312,273,3673,6167,446,5820,8307,3284,9303,2301,9585,892,5947,9459,7325,715,3796,4741,3628,623,5219,2164,2591,7413,2053,6395,1738,2717,2233,131,3799,8896,6755,3823,5062,3553,5994,9720,6836,5296,2020,2772,6187,4319,2230,3511,5033,6025,4603,5012,2999,6174,3528,1942,3586,1932,8336,5323,4648,6920,5454,8446,5816,2208,2269,877,2112,8262,597,8947,9910,2616,8071,6096,6934,300,5959,8318,2677,561,9682,2027,6734,3209,3968,319,5140,8656,1994,9787,5575,7447,4585,7742,6006,6853,8619,4470,1466,5567,3416,1375,4534,7838,3823,7820,4490,9781,2489,7166,6693,2170,5544,3427,5378,5864,97,517,4519,8442,6656,6445,5888,1240,4187,8246,4444,9157,2715,2261,4723,2482,3636,5608,320,7458,3427,4809,3590,5916,8326,282,8085,221,60,9815,6084,6509,6683,6954,4950,3338,9751,7190,929,3937,1787,1724,3093,4501,3985,4167,3334,7620,9774,5,1429,9553,1165,1370,1820,5842,8003,6256,2415,8063,6070,4850,923,9105,1804,5872,8794,7906,3061,9723,1842,4847,1446,1286,5699,1782,1804,5385,5753,7929,1741,3533,3833,2906,4902,5652,5099,2905,1908,7513,7319,4329,2363,8241,3433,518,4112,2227,8423,3525,8301,6616,8371,6098,4253,422,7880,6056,5806,9984,336,3898,3517,4169,6803,8418,9820,8254,7674,8079,5766,4992,8760,4480,3232,8544,1349,7344,7122,9771,868,5422,2738,5590,7872,6990,2363,2103,9397,4520,2086,9733,8418,1954,3901,1572,372,72,9825,8045,8151,1943,9389,3262,6422,2620,1805,7771,6315,5279,3893,3534,700,6631,5476,4923,3620,7838,3377,9369,2358,5463,9101,7127,7416,3001,8698,4139,9424,8523,8536,3926,465,7924,7187,3238,6895,5344,1008,3210,622,4901,6743,7673,7883,8570,2596,7854,6408,5972,7222,5117,7786,6322,2243,1554,5674,940,2044,5098,5814,579,9023,2630,4854,2562,5868,1749,7905,6875,1310,4878,8127,8052,2550,6009,2974,1497,215,9381,3821,7436,4497,1606,110,3091,9511,5783,4030,1555,7232,6196,8485,2607,8825,3339,5168,4692,5087,3072,7919,6396,7949,6045,799,6850,8406,3772,8347,4972,9504,2167,2407,4000,124,2516,7090,5987,4651,7472,7541,8234,3667,6025,840,2491,5715,6007,3535,801,5430,1453,3548,9730,7497,4347,6580,2254,4470,1278,7225,3974,9796,5984,4325,6271,4851,7767,2257,9501,1590,6149,7735,1608,8526,4926,4098,4240,933,7632,1393,6362,9084,4940,2444,2933,5638,9023,1538,108,6652,5115,433,6447,1098,1109,2717,2300,8875,1326,1801,6816,7474,5887,8423,5999,812,2521,6591,8096,6504,7983,810,1940,2922,3253,1224,4912,8627,9113,1371,1630,4227,1803,8076,1676,9263,7144,328,8138,8469,8480,1305,2295,4366,9728,4645,1529,8600,1235,5977,1455,5569,6786,3394,8491,6390,969,3402,1368,6434,4772,2997,7012,2926,7424,8688,2188,4567,9015,6677,9388,7494,7982,8034,8211,4061,2678,6091,2660,265,8419,4114,5833,1556,3860,675,7945,4828,428,5664,1261,1551,8660,8273,4476,6083,3312,3016,7002,8678,9692,6389,2523,4025,774,7085,8085,3451,9527,7096,67,7946,1210,5900,5853,5069,2926,150,6248,3354,5813,3861,4904,4473,8485,9380,6907,8148,8747,3908,3177,4790,6648,2051,8815,7421,9135,3251,7224,5013,347,7290,9310,7908,9541,5163,9328,2467,5312,1927,5820,1124,2139,723,1948,623,6454,8855,5122,5200,9114,8298,6342,2114,348,1508,5886,5834,4758,3109,7199,1456,6751,6508,5715,2643,1670,1394,5109,3333,3321,7280,809,5459,4355,2756,2434,7160,7962,3907,8712,3428,8557,5053,5541,8904,6560,1426,1090,7669,887,8288,9125,3989,1147,1191,6631,2817,2585,8092,2501,5905,5371,3309,7715,6077,2417,6500,3237,378,407,1948,157,8963,7000,2049,4218,9911,9827,1659,7579,713,9946,3055,4701,1093,4246,7683,261,6830,5774,9113,9086,7497,2422,3152,3573,4838,9652,6809,1567,58,8756,1724,5372,2107,3772,9589,2017,9950,1248,5948,662,7545,9002,1714,4989,3247,5749,1601,6428,1522,714,1865,9018,9487,5017,2591,676,4668,5751,2242,1077,859,317,2800,9317,441,2388,1334,390,9987,3633,7404,3884,2634,5469,5224,2233,1217,6825,5012,9091,3890,6877,8108,3376,8245,7050,4051,9264,2801,2644,340,3659,9313,3139,9327,6105,1878,7012,6494,8217,644,249,8452,9630,5718,3675,1862,3286,6851,3225,2376,740,6453,484,467,4697,3885,869,3960,3037,9865,651,3047,9177,3789,2374,5281,2019,9385,8126,6587,29,4727,5038,9658,444,8712,7871,81,1915,1095,2457,9006,7548,9292,9473,8596,3176,6693,2556,6213,6557,3206,5611,2085,3347,7984,3717,1717,7369,8195,8303,3749,2921,3340,3406,9716,8403,1276,9796,317,8722,2252,9323,2621,7895,5147,1217,1071,1839,124,3635,4748,9681,9245,6832,9379,3581,6901,1095,949,5095,9397,4697,8015,2736,4454,4082,1139,2081,3877,7807,7154,2481,7129,9775,375,8627,7343,7797,6818,3818,1431,1565,3498,7028,4748,2877,6960,1648,3971,7908,3094,3368,8956,1108,2455,9761,5189,3593,1841,5418,7752,8994,7898,1232,5120,8272,9859,2462,6069,6676,2631,3851,4592,6129,7230,9339,5357,4189,7339,9327,8448,432,9046,7403,7892,1501,7163,3080,1445,5355,4849,9196,701,2746,6780,5820,7370,6638,4634,3438,9665,7264,3640,4256,9744,870,9946,5100,5058,7284,779,3506,4068,9824,7260,1959,7676,775,1390,5473,2481,6239,1020,3181,5336,7799,5353,2705,4436,9986,2494,452,3601,6134,4707,3345,3355,1005,8444,4764,8288,9222,4621,2355,5398,1881,665,3073,9007,2055,8545,1487,8293,9565,1020,3628,3715,6372,2685,8151,6357,5178,8602,6309,7663,9661,9653,1017,665,4449,5781,5304,3670,6753,4011,5419,4985,4675,8492,3991,3081,3388,1830,1373,9304,2849,1353,3019,9220,4037,7521,1928,5566,2474,8236,3229,2134,7889,4245,9150,2337,6377,806,2358,3130,1168,7777,8114,2194,2620,8457,5275,2359,286,2999,1663,3134,703,1033,8705,1091,8553,632,6657,1026,8867,9885,9512,3107,481,5013,1795,6858,5818,4153,6339,3337,8281,804,5531,900,9260,805,3258,5897,155,1272,9030,858,2304,4086,1948,7208,4717,8604,4586,9936,4840,4097,9394,5321,9109,1189,8530,1279,1693,1220,4615,9973,2023,6497,7224,7635,3653,6833,3531,3808,8105,8913,1017,6760,2998,9316,3968,4067,7920,8553,4002,9111,9001,9747,4431,4461,7287,9312,2091,8979,531,6706,5303,2554,9554,8878,6540,3207,5711,70,7014,167,8982,8030,3278,8332,7345,3597,2398,1616,2149,2751,7079,7501,8849,7861,1962,6136,7173,4052,5114,7703,7109,6769,6608,6663,5646,3147,9869,7708,9569,3234,4226,4902,7615,7504,3233,1311,1100,1982,9279,9601,1084,6357,7101,9933,4217,5414,6068,7741,5818,7533,1796,2926,4301,4755,5940,6299,4254,2160,4006,3822,5393,8232,8723,9359,2087,8308,670,3186,6641,6300,9138,7725,2656,6239,7657,3224,8004,76,7317,3821,7608,9112,3099,8261,3866,9038,4559,8119,7550,8564,8292,9294,3147,3367,8653,1585,1674,5674,4771,4666,1973,260,2390,980,6498,6398,555,854,6473,7871,4674,433,3334,7772,8693,3552,6810,3251,8022,4359,8166,6314,3652,7665,6032,8656,9249,4057,4329,371,8722,2653,631,1112,9984,3480,3861,539,4333,6686,4761,9007,7118,8095,3130,2162,7998,6291,1764,6019,649,6281,8684,653,3945,4715,5660,9546,8771,9989,6268,3845,8993,6898,1308,8977,6730,5168,9515,1062,8205,627,6420,1674,8721,9550,3835,3070,5840,1950,9089,2841,8231,4124,9845,8527,5191,5504,8072,3961,1844,4340,4157,837,7589,5464,9813,670,632,5679,8084,8836,6305,4503,6862,1378,404,696,4447,2596,2646,9887,1788,7228,363,7984,5754,5553,9839,178,5865,1683,869,22,8871,8457,5485,5035,9127,2468,7065,7210,7656));
		//calculateMinTime(list,988);
		//calculateMaxTime(list,988);
		ArrayList<Integer> list=new ArrayList<>(Arrays.asList(1000000,1000000));
		System.out.println(PaintersPartition.paint(1,1000000, list));

	}

	public static int paint(int A, int B, ArrayList<Integer> C) {
		long time = 0;
		long minTime = calculateMinTime(C, B);
		System.out.println("Min time "+minTime);
		long ans = minTime;
		long maxTime = calculateMaxTime(C, B);
		System.out.println("Max time "+maxTime);
		while (minTime <= maxTime) {
			time = minTime + (maxTime - minTime) / 2;
			//time=4609098;
			
			int countPainters = PaintersPartition.findNumberOfPainters(time, C, B);

			System.out.println("count " + countPainters + "   for time "+time);
			double countPaintersForLessTime = findNumberOfPainters(time - 1, C, B);
			if (countPainters == A && countPaintersForLessTime > countPainters) {
				System.out.println("returning from mainwhile");
				return (int) (time % 10000003);
			}
			  if(countPainters<=A)
			  {
				  System.out.println(" we have to increse number of painter");
				  //it is resulting into increase in time
                  maxTime=time-1;
				  
			  }
			  else
			  {
				  System.out.println("in else part");
				  minTime=time+1;
			  }
		}
        System.out.println("Returning from gere "+time);
		return (int) time % 10000003;
	}

	public static int findNumberOfPainters(long time,ArrayList<Integer> C,int B)
    {
        long unitTime= (long) B;
    	long count=1;
    	long currTimeLeft=time;
    	for(long length:C)
    	{
    		if(currTimeLeft >= (length*unitTime))
    		{
    			currTimeLeft= currTimeLeft- (length *unitTime);
    		}
    		else
    		{
    			//count=(count +1)%10000003;
    			count=count +1;
    			currTimeLeft=  time -(length *unitTime);
    		}
    		
    	}
		return (int)count;
    }

	// min time calculate when considering n numebrs of workers are available
	public static long calculateMinTime(ArrayList<Integer> C, int B) {
		long minTime = 0;
		long unitTime=(long) B;
		for (long len : C) {
			//System.err.println("-------"+len*unitTime);
			minTime = Math.max(len*unitTime, minTime);
			//System.out.println("min Time "+minTime);
		}
		return minTime;
	}

	// max time calcualte when considering only 1 painterr available
	public static long calculateMaxTime(ArrayList<Integer> C, int B) {
		long maxTime = 0;
		long unitTime=(long) B;
		for (long len : C) {
			//System.out.println("time   " +len);
			
			maxTime= maxTime+ len;
			
			//System.out.println("maxTime without multiplication"+maxTime);
		}
		maxTime=maxTime*unitTime;
		System.out.println("max timw with multiploication  "+maxTime);
		
		//System.out.println();
		return maxTime;
	}
}
