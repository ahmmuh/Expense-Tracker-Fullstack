"use client";
import Link from "next/link";
import { redirect } from "next/navigation";
import React from "react";
import LoginPage from "../auth/page";
import DashboardCard from "@/components/dashboardCard";

function DashboardPage() {
  return (
    <div className="flex  items-center gap-3 border-b-2">
      <DashboardCard
        title={"Total Balance"}
        titleColor={"text-black"}
        textColor={"black"}
        amount={1100.0}
        smallText={"0% from last month"}
      />
      <DashboardCard
        title={"Monthly Income"}
        titleColor={"text-green-600"}
        textColor={"green"}
        amount={4000 - 0.0}
        smallText={"This month"}
      />
      <DashboardCard
        title={"Monthly Expenses"}
        titleColor={"text-red-700"}
        textColor={"red"}
        amount={2900.0}
        smallText={"This month"}
      />

      <DashboardCard
        title={"Savings Rate"}
        textColor={"green"}
        amount={10}
        smallText={"Of Income"}
      />
    </div>
  );
}

export default DashboardPage;
