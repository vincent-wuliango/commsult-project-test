import Layout from '../layouts/Layout'
import '../styles/global.css'
import Head from 'next/head'
import 'bootstrap/dist/css/bootstrap.min.css'

function App({ Component, pageProps }) {
    return(
    <>
        <Head>
            <meta name="viewport" content="minimum-scale=1, initial-scale=1, width=device-width"/>
        </Head>
        <Layout title={process.env.appName}>
            <Component {...pageProps} />
        </Layout>
    </>
    )
}

export default App