package com.shenzhou.entity.member;

import java.math.BigDecimal;

/**
 * Created by cty on 2016/10/20.
 */
public class MemberStatistics {
    private String id;//主键
    private String name;//名称"
    private String memberID;//会员ID"
    private Member member;
    private Integer point;
    private Integer pointTotal;
    private Integer pointTotalUsed;
    private Integer golden;
    private Integer goldenTotal;
    private Integer goldenTotalUsed;
    private Double flexibleBalance;
    private Double flexibleInterestTotal;
    private Double flexibleTotalOrder;
    private Double flexibleTotalclosing;
    private Double bankBillBalance;
    private Double bankBillTotalOrder;
    private Double bankBillTotalClosing;
    private Double bankBillInterest;
    private Double regularBalance;
    private Double regularTotalOrder;
    private Double regularTotalClosing;
    private Double regularInterest;
    private Double businessBillBalance;
    private Double businessBillTotalOrder;
    private Double businessBillTotalClosing;
    private Double businessBillInterest;
    private Double cashBalance;
    private Double cashTotalRecharge;
    private Double cashTotalCashBonus;
    private Double cashTotalConsumer;
    private Double cashTotalWithdraw;
    private Double cashTotalInterest;
    private Double rebateBalance;
    private Double rebateTotal;
    private Double rebateTotalUsed;
    private Double bonusTotal;
    private Double bonusUsedTotal;
    private Integer divineApplyNumber;
    private Double divineApplyAmount;
    private Integer divineDoneNumber;
    private Double divineDoneAmount;
    private Integer rewardApplyNumber;
    private Double rewardApplyAmount;
    private Integer rewardDoneNumber;
    private Double rewardDoneAmount;
    private Integer scoreNumber;
    private Integer scoreTotal;
    private Integer scoreGoodTimes;
    private int guanzhu;
    private int fensi;
    private int livevideoNum;
    private String isGuanzhu;
    private String birthdayString;
    private int bean;
    private String isBlack;
    /*
     *10.20号加关于众筹的信息
     */
    private Integer crowdTimes;
    private Double crowdAmount;
    private Integer joinCrowdProjects;
    private Integer joinCrowdPhases;
    private Integer joinCrowdTimes;
    private Double joinCrowdAmount;
    private Integer recommendMembers;
    private Double cashTotalIncome;
    private Double noCashTotalIncome;

    private Double cashTotalWithdrawProcess = 0d;//累计提现中金额

    public Double getNoCashTotalIncome() {
        return noCashTotalIncome;
    }

    public void setNoCashTotalIncome(Double noCashTotalIncome) {
        this.noCashTotalIncome = noCashTotalIncome;
    }

    public Double getCashTotalIncome() {
        return cashTotalIncome;
    }

    public void setCashTotalIncome(Double cashTotalIncome) {
        BigDecimal b = new BigDecimal(cashTotalIncome);
        this.cashTotalIncome = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public Integer getCrowdTimes() {
        return crowdTimes;
    }

    public void setCrowdTimes(Integer crowdTimes) {
        this.crowdTimes = crowdTimes;
    }

    public Double getCrowdAmount() {
        return crowdAmount;
    }

    public void setCrowdAmount(Double crowdAmount) {
        this.crowdAmount = crowdAmount;
    }

    public Integer getJoinCrowdProjects() {
        return joinCrowdProjects;
    }

    public void setJoinCrowdProjects(Integer joinCrowdProjects) {
        this.joinCrowdProjects = joinCrowdProjects;
    }

    public Integer getJoinCrowdPhases() {
        return joinCrowdPhases;
    }

    public void setJoinCrowdPhases(Integer joinCrowdPhases) {
        this.joinCrowdPhases = joinCrowdPhases;
    }

    public Integer getJoinCrowdTimes() {
        return joinCrowdTimes;
    }

    public void setJoinCrowdTimes(Integer joinCrowdTimes) {
        this.joinCrowdTimes = joinCrowdTimes;
    }

    public Double getJoinCrowdAmount() {
        return joinCrowdAmount;
    }

    public void setJoinCrowdAmount(Double joinCrowdAmount) {
        this.joinCrowdAmount = joinCrowdAmount;
    }

    public Integer getRecommendMembers() {
        return recommendMembers;
    }

    public void setRecommendMembers(Integer recommendMembers) {
        this.recommendMembers = recommendMembers;
    }

    public String getIsBlack() {
        return isBlack;
    }

    public void setIsBlack(String isBlack) {
        this.isBlack = isBlack;
    }

    public int getBean() {
        return bean;
    }

    public void setBean(int bean) {
        this.bean = bean;
    }

    public String getBirthdayString() {
        return birthdayString;
    }

    public void setBirthdayString(String birthdayString) {
        this.birthdayString = birthdayString;
    }

    public String getIsGuanzhu() {
        return isGuanzhu;
    }

    public void setIsGuanzhu(String isGuanzhu) {
        this.isGuanzhu = isGuanzhu;
    }

    /*@JsonIgnore
    private Rank rank;

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }*/

    private String rankID;
    private String rankName;
    private String rankListImage;

    public int getGuanzhu() {
        return guanzhu;
    }

    public void setGuanzhu(int guanzhu) {
        this.guanzhu = guanzhu;
    }

    public int getFensi() {
        return fensi;
    }

    public void setFensi(int fensi) {
        this.fensi = fensi;
    }

    public int getLivevideoNum() {
        return livevideoNum;
    }

    public void setLivevideoNum(int livevideoNum) {
        this.livevideoNum = livevideoNum;
    }

    public String getRankID() {
        return rankID;
    }

    public void setRankID(String rankID) {
        this.rankID = rankID;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getRankListImage() {
        return rankListImage;
    }

    public void setRankListImage(String rankListImage) {
        this.rankListImage = rankListImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getPointTotal() {
        return pointTotal;
    }

    public void setPointTotal(Integer pointTotal) {
        this.pointTotal = pointTotal;
    }

    public Integer getPointTotalUsed() {
        return pointTotalUsed;
    }

    public void setPointTotalUsed(Integer pointTotalUsed) {
        this.pointTotalUsed = pointTotalUsed;
    }

    public Integer getGolden() {
        return golden;
    }

    public void setGolden(Integer golden) {
        this.golden = golden;
    }

    public Integer getGoldenTotal() {
        return goldenTotal;
    }

    public void setGoldenTotal(Integer goldenTotal) {
        this.goldenTotal = goldenTotal;
    }

    public Integer getGoldenTotalUsed() {
        return goldenTotalUsed;
    }

    public void setGoldenTotalUsed(Integer goldenTotalUsed) {
        this.goldenTotalUsed = goldenTotalUsed;
    }

    public Double getFlexibleBalance() {
        return flexibleBalance;
    }

    public void setFlexibleBalance(Double flexibleBalance) {
        this.flexibleBalance = flexibleBalance;
    }

    public Double getFlexibleInterestTotal() {
        return flexibleInterestTotal;
    }

    public void setFlexibleInterestTotal(Double flexibleInterestTotal) {
        this.flexibleInterestTotal = flexibleInterestTotal;
    }

    public Double getFlexibleTotalOrder() {
        return flexibleTotalOrder;
    }

    public void setFlexibleTotalOrder(Double flexibleTotalOrder) {
        this.flexibleTotalOrder = flexibleTotalOrder;
    }

    public Double getFlexibleTotalclosing() {
        return flexibleTotalclosing;
    }

    public void setFlexibleTotalclosing(Double flexibleTotalclosing) {
        this.flexibleTotalclosing = flexibleTotalclosing;
    }

    public Double getBankBillBalance() {
        return bankBillBalance;
    }

    public void setBankBillBalance(Double bankBillBalance) {
        this.bankBillBalance = bankBillBalance;
    }

    public Double getBankBillTotalOrder() {
        return bankBillTotalOrder;
    }

    public void setBankBillTotalOrder(Double bankBillTotalOrder) {
        this.bankBillTotalOrder = bankBillTotalOrder;
    }

    public Double getBankBillTotalClosing() {
        return bankBillTotalClosing;
    }

    public void setBankBillTotalClosing(Double bankBillTotalClosing) {
        this.bankBillTotalClosing = bankBillTotalClosing;
    }

    public Double getBankBillInterest() {
        return bankBillInterest;
    }

    public void setBankBillInterest(Double bankBillInterest) {
        this.bankBillInterest = bankBillInterest;
    }

    public Double getRegularBalance() {
        return regularBalance;
    }

    public void setRegularBalance(Double regularBalance) {
        this.regularBalance = regularBalance;
    }

    public Double getRegularTotalOrder() {
        return regularTotalOrder;
    }

    public void setRegularTotalOrder(Double regularTotalOrder) {
        this.regularTotalOrder = regularTotalOrder;
    }

    public Double getRegularTotalClosing() {
        return regularTotalClosing;
    }

    public void setRegularTotalClosing(Double regularTotalClosing) {
        this.regularTotalClosing = regularTotalClosing;
    }

    public Double getRegularInterest() {
        return regularInterest;
    }

    public void setRegularInterest(Double regularInterest) {
        this.regularInterest = regularInterest;
    }

    public Double getBusinessBillBalance() {
        return businessBillBalance;
    }

    public void setBusinessBillBalance(Double businessBillBalance) {
        this.businessBillBalance = businessBillBalance;
    }

    public Double getBusinessBillTotalOrder() {
        return businessBillTotalOrder;
    }

    public void setBusinessBillTotalOrder(Double businessBillTotalOrder) {
        this.businessBillTotalOrder = businessBillTotalOrder;
    }

    public Double getBusinessBillTotalClosing() {
        return businessBillTotalClosing;
    }

    public void setBusinessBillTotalClosing(Double businessBillTotalClosing) {
        this.businessBillTotalClosing = businessBillTotalClosing;
    }

    public Double getBusinessBillInterest() {
        return businessBillInterest;
    }

    public void setBusinessBillInterest(Double businessBillInterest) {
        this.businessBillInterest = businessBillInterest;
    }

    public Double getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(Double cashBalance) {
        BigDecimal b = new BigDecimal(cashBalance);
        this.cashBalance = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public Double getCashTotalRecharge() {
        return cashTotalRecharge;
    }

    public void setCashTotalRecharge(Double cashTotalRecharge) {
        this.cashTotalRecharge = cashTotalRecharge;
    }

    public Double getCashTotalCashBonus() {
        return cashTotalCashBonus;
    }

    public void setCashTotalCashBonus(Double cashTotalCashBonus) {
        this.cashTotalCashBonus = cashTotalCashBonus;
    }

    public Double getCashTotalConsumer() {
        return cashTotalConsumer;
    }

    public void setCashTotalConsumer(Double cashTotalConsumer) {
        this.cashTotalConsumer = cashTotalConsumer;
    }

    public Double getCashTotalWithdraw() {
        return cashTotalWithdraw;
    }

    public void setCashTotalWithdraw(Double cashTotalWithdraw) {
        this.cashTotalWithdraw = cashTotalWithdraw;
    }

    public Double getCashTotalInterest() {
        return cashTotalInterest;
    }

    public void setCashTotalInterest(Double cashTotalInterest) {
        this.cashTotalInterest = cashTotalInterest;
    }

    public Double getRebateBalance() {
        return rebateBalance;
    }

    public void setRebateBalance(Double rebateBalance) {
        this.rebateBalance = rebateBalance;
    }

    public Double getRebateTotal() {
        return rebateTotal;
    }

    public void setRebateTotal(Double rebateTotal) {
        this.rebateTotal = rebateTotal;
    }

    public Double getRebateTotalUsed() {
        return rebateTotalUsed;
    }

    public void setRebateTotalUsed(Double rebateTotalUsed) {
        this.rebateTotalUsed = rebateTotalUsed;
    }

    public Double getBonusTotal() {
        return bonusTotal;
    }

    public void setBonusTotal(Double bonusTotal) {
        this.bonusTotal = bonusTotal;
    }

    public Double getBonusUsedTotal() {
        return bonusUsedTotal;
    }

    public void setBonusUsedTotal(Double bonusUsedTotal) {
        this.bonusUsedTotal = bonusUsedTotal;
    }

    public Integer getDivineApplyNumber() {
        return divineApplyNumber;
    }

    public void setDivineApplyNumber(Integer divineApplyNumber) {
        this.divineApplyNumber = divineApplyNumber;
    }

    public Double getDivineApplyAmount() {
        return divineApplyAmount;
    }

    public void setDivineApplyAmount(Double divineApplyAmount) {
        this.divineApplyAmount = divineApplyAmount;
    }

    public Integer getDivineDoneNumber() {
        return divineDoneNumber;
    }

    public void setDivineDoneNumber(Integer divineDoneNumber) {
        this.divineDoneNumber = divineDoneNumber;
    }

    public Double getDivineDoneAmount() {
        return divineDoneAmount;
    }

    public void setDivineDoneAmount(Double divineDoneAmount) {
        this.divineDoneAmount = divineDoneAmount;
    }

    public Integer getRewardApplyNumber() {
        return rewardApplyNumber;
    }

    public void setRewardApplyNumber(Integer rewardApplyNumber) {
        this.rewardApplyNumber = rewardApplyNumber;
    }

    public Double getRewardApplyAmount() {
        return rewardApplyAmount;
    }

    public void setRewardApplyAmount(Double rewardApplyAmount) {
        this.rewardApplyAmount = rewardApplyAmount;
    }

    public Integer getRewardDoneNumber() {
        return rewardDoneNumber;
    }

    public void setRewardDoneNumber(Integer rewardDoneNumber) {
        this.rewardDoneNumber = rewardDoneNumber;
    }

    public Double getRewardDoneAmount() {
        return rewardDoneAmount;
    }

    public void setRewardDoneAmount(Double rewardDoneAmount) {
        this.rewardDoneAmount = rewardDoneAmount;
    }

    public Integer getScoreNumber() {
        return scoreNumber;
    }

    public void setScoreNumber(Integer scoreNumber) {
        this.scoreNumber = scoreNumber;
    }

    public Integer getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(Integer scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public Integer getScoreGoodTimes() {
        return scoreGoodTimes;
    }

    public void setScoreGoodTimes(Integer scoreGoodTimes) {
        this.scoreGoodTimes = scoreGoodTimes;
    }

    public Double getCashTotalWithdrawProcess() {
        return cashTotalWithdrawProcess;
    }

    public void setCashTotalWithdrawProcess(Double cashTotalWithdrawProcess) {
        this.cashTotalWithdrawProcess = cashTotalWithdrawProcess;
    }
}
