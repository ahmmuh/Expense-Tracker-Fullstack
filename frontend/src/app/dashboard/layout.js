import Link from "next/link";
import React from "react";
import LoginPage from "../auth/page";
import { FaUsersLine } from "react-icons/fa6";
import { GiExpense } from "react-icons/gi";
import { MdOutlineAttachMoney } from "react-icons/md";
import { FaHome } from "react-icons/fa";

function DashboardLayout({ children }) {
  const isAuthenticated = true;

  return (
    <div className="flex  justify-between h-screen  p-10 bg-white">
      {isAuthenticated ? (
        <>
          <div className="w-1/3 border-l-emerald-600 border-r px-2">
            <ul className="flex flex-col">
              <li className="mb-1 text-2xl text-blue-400 border-b py-2">
                <Link href={"/dashboard"} className="flex items-center">
                  <FaHome />
                  <span className="ml-5">Home</span>
                </Link>
              </li>
              <li className="mb-1 text-2xl text-blue-400 border-b py-2">
                <Link href={"/dashboard/users"} className="flex  items-center">
                  <FaUsersLine />
                  <span className="ml-5">Customers</span>
                </Link>
              </li>
              <li className="mb-1 text-2xl text-blue-400 border-b py-2">
                <Link
                  href={"/dashboard/budgets"}
                  className="flex  items-center">
                  <MdOutlineAttachMoney />
                  <span className="ml-5">Budget</span>
                </Link>
              </li>
              <li className="mb-1 text-2xl text-blue-400 border-b py-2">
                <Link
                  href={"/dashboard/expenses"}
                  className="flex  items-center">
                  <GiExpense />

                  <span className="ml-5">Expenses</span>
                </Link>
              </li>
            </ul>
          </div>
          <div className="w-full p-5">
            <h1 className="text-3xl">Dashboard</h1>
            <p className="text-blue-400">{children}</p>
          </div>
        </>
      ) : (
        <LoginPage />
      )}
    </div>
  );
}

export default DashboardLayout;
