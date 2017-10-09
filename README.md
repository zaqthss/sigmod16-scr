# sigmod16-scr
Code release of ["Sequential Data Cleaning: A Statistical Approach." (SIGMOD 16)](https://dl.acm.org/citation.cfm?doid=2882903.2915233).
The description of code files are listed below:

- `DP.java`: Algorithm 1 in the paper. Use the exact DP based algorithm to repair time series with learned V model.
- `TimePoint.java`: the class for TimePoint indicating a time point
- `TimeSeries.java`: the class for TimeSeries indicating a time sereis.

Datasets
----------
The public datasets in the paper:

- [STOCK](http://finance.yahoo.com/q/hp?s=AIP.L+Historical+Prices) with synthetic errors.

The schema of the data file contains three columns, 

- timestamp: the timestamp of the data
- dirty: the observation
- truth: the truth

Attention

- The example dataset is `data/stock1.2k.data` and `data/stock10k.data`, in case the link is out of date
- When running test for `data/stock10k.data`, a large memeory at least 15G is needed
- The V model containing the valid range of 'disV' is learned with background knowledge. The automatic method is considered in the future work. Currently is written in the `Constants.java`.

Parameters
----------
The input and output of **DP** algorithm is:

Method

```
DP(dirtySeries, THETA, delta)
normalizeParams(RES, PARAM);
normalizeProbability();
mainDP()
```

Input:

```
double THETA = 5;               // error range $\theta$
double delta = 1500;            // repair budget $\delta$
double RES = 0.1;               // resolution of the data
int PARAM = 10;                 // 1 / RES
TimeSeries dirtySeries
```

V model from background knowledge
```
double MINV = -101;
double MAXV = 99;
double INTERV = 1;
```

Output

```
Timeseries resultSeries
```

Citation
----------
If you use this code for your research, please consider citing:

```
@inproceedings{DBLP:conf/sigmod/ZhangSW16,
  author    = {Aoqian Zhang and
               Shaoxu Song and
               Jianmin Wang},
  title     = {Sequential Data Cleaning: {A} Statistical Approach},
  booktitle = {Proceedings of the 2016 International Conference on Management of
               Data, {SIGMOD} Conference 2016, San Francisco, CA, USA, June 26 -
               July 01, 2016},
  pages     = {909--924},
  year      = {2016}
}
```
