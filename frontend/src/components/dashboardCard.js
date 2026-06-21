import React from "react";

function DashboardCard({
  title,
  titleColor,
  amount,
  smallText,
  bgColor,
  textColor,
  savedAmount,
}) {
  return (
    <div
      className={`mb-2 flex flex-col w-1/4  hover:bg-pink-100  shadow-lg  p-5 bg-gray-50  gap-4`}>
      <h4 className={titleColor}>{title}</h4>
      <p className={textColor}>${amount}</p>
      <p>{savedAmount}%</p>
      <span className="text-sm">{smallText}</span>
    </div>
  );
}

export default DashboardCard;
