#ifndef __ACCOUNT_H__
#define __ACCOUNT_H__
#include "date.h"
#include <string>

class SavingAccount{
public:
    SavingAccount(const Date &date, const std::string &id, double rate);
    const std::string &getId() const{return id;}
    double getBalance() const{return balance;}
    double getRate() const{return rate;}
    static double getTotal() {return total;}
    void deposit(const Date& date, double amount, const std::string& desc);
    void withdraw(const Date& date, double amount, const std::string& desc);
    void settle(const Date& date);
    void show() const;
private:
    std::string id;         //账号
    double balance;         //余额
    double rate;            //年利率
    Date lastDate;          //上次变更余额日期
    double accumulation;    //余额按日累加
    static double total;
    void record(const Date& date, double amount, const std::string& desc);
    void error(const std::string& msg) const;
    double accumulate(const Date& date) const{
        return accumulation + balance * date.distance(lastDate);
    };
};
#endif