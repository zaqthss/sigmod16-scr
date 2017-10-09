package cn.edu.thu.scr.test;

import cn.edu.thu.scr.DP;
import cn.edu.thu.scr.entity.TimeSeries;
import cn.edu.thu.scr.util.Assist;

/**
 * Created by Stoke on 2017/10/8.
 * E-mail address is zaqthss2009@gmail.com
 * Copyright © Stoke. All Rights Reserved.
 *
 * @author Stoke
 */
public class DPTest {

  public static void main(String[] args) {
    String inputFileName = "stock1.2k.data";
//    String inputFileName = "stock10k.data"; may be out of memory under 10G

    Assist assist = new Assist();
    String splitOp = ",";

    TimeSeries dirtySeries = assist.readData(inputFileName, 1, splitOp);
    TimeSeries truthSeries = assist.readData(inputFileName, 2, splitOp);

    double rmsDirty = assist.calcRMS(truthSeries, dirtySeries);
    System.out.println("Dirty RMS error is " + rmsDirty);

    double RES = 0.1;     // the resolution of the data
    int PARAM = 10;       // RES * PARAM = 1, the normalized parameter
    double THETA = 5;     // after normalized
    double delta = 1500;

    assist.buildVModel();
    DP dp = new DP(dirtySeries, THETA, delta);
    dp.normalizeParams(RES, PARAM);
    dp.normalizeProbability(assist);
    TimeSeries resultSeries = dp.mainDP();

    double rms = assist.calcRMS(truthSeries, resultSeries);

    System.out.println("Repair RMS error is " + rms);
  }
}
