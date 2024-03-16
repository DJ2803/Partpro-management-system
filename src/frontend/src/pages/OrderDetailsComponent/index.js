// LoginScreen.js

import React  from 'react';
import { useLocation } from "react-router-dom";
import {

  FeaturesSec,
} from "../../components/DetaisSection/Features.elements";
export default function OrderDetailsComponent({ lightTopLine }) {
 
    const location = useLocation();
    const queryParams = new URLSearchParams(location.search);
    const paymentId = queryParams.get('paymentId');
    const status = queryParams.get('status');
  return (
    <>
      <FeaturesSec>
      <div>
      <p>Payment ID: {paymentId}</p>
      <p>Status: {status}</p>
    </div>
      </FeaturesSec>
    </>
  );
};


