import Link from "next/link";
import React from "react";

function LoginPage() {
  return (
    <div className="w-full flex justify-center items-center flex-col">
      <h2 className="text-2xl mb-10">Please login</h2>

      <div className="flex flex-col pb-4 w-1/2">
        <input placeholder="Username" className="border p-2 rounded-2xl mb-3" />
        <input placeholder="Password" className="border p-2 rounded-2xl mb-3" />
        <Link
          href={"/dashboard"}
          className="bg-blue-500 text-white text-center py-2 rounded-2xl hover:bg-blue-300">
          Login
        </Link>
      </div>
    </div>
  );
}

export default LoginPage;
