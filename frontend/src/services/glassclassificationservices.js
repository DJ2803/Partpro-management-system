

const GLASS_API_URL = 'http://localhost:8001';



export async function fetchBoxPlots() {
  try {
    const response = await fetch(
      `${GLASS_API_URL}/ml/boxplot`
    );

    const data = await response.json();
    console.log(data);
    return data;
  } catch (error) {
    console.log(error);
    return;
  }
}


export async function fetchPairPlots() {
  try {
    const response = await fetch(
      `${GLASS_API_URL}/ml/boxplot`
    );

    const data = await response.json();
    console.log(data);
    return data;
  } catch (error) {
    console.log(error);
    return;
  }
}




