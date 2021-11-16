import axios from 'axios'

export const loginUser = async (email, password) => {
   const {data} = await axios.post('/', { email, password });
   console.log(data);
}