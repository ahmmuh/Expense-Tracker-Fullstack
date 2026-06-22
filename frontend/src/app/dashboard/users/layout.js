import Link from "next/link";
import React from "react";
import { FaAd } from "react-icons/fa";
import { FaDollarSign, FaMoneyBills, FaUsersLine } from "react-icons/fa6";

function UserLayout({ children }) {
  return (
    <div className="w-1/2">
      <div className="flex gap-3">
        <Link
          className="flex items-center bg-blue-200 p-2 w-full text-gray-700"
          href={"/dashboard/users"}>
          <FaUsersLine />
          <span className="ml-3">Customers</span>
        </Link>
        <Link
          href={"/dashboard/users/registration"}
          className="flex items-center bg-blue-200 p-2 w-full text-gray-700">
          <span className="ml-3">Add Customer</span>
        </Link>
      </div>
      {children}
    </div>
  );
}

export default UserLayout;
