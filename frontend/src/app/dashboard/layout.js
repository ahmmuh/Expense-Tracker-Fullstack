import Link from "next/link";
import React from "react";
import LoginPage from "../auth/page";

function DashboardLayout({ children }) {
  const isAuthenticated = true;

  return (
    <div className="flex  justify-between h-screen  p-10 bg-white">
      {isAuthenticated ? (
        <>
          <div className="w-1/3 border-l-emerald-600 border-r px-2">
            <ul className="flex flex-col">
              <li className="mb-1 text-2xl text-blue-400 border-b py-2">
                <Link href={"/dashboard"}>Dashboard</Link>
              </li>
              <li className="mb-1 text-2xl text-blue-400 border-b py-2">
                <Link href={"/dashboard/users"}>Profile</Link>
              </li>
              <li className="mb-1 text-2xl text-blue-400 border-b py-2">
                <Link href={"/dashboard/budgets"}>Budget</Link>
              </li>
              <li className="mb-1 text-2xl text-blue-400 border-b py-2">
                <Link href={"/dashboard/expenses"}>Expenses</Link>
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
