import Head from 'next/head'

function Blog({ title, description }) {
    return(
        <>
            <Head>
                <title>{title}</title>
                <meta name='description' content={description}/>
            </Head>
            <h1 className='content'>
                Env Analytics {process.env.NEXT_PUBLIC_ANALYTICS_ID}
            </h1>
        </>
    )
}

export default Blog

export async function getServerSideProps() {
    const dbUser = process.env.DB_USER
    const dbPassword = process.env.DB_PASSWORD

    console.log(
      `Connect user=${dbUser} and pass=${dbPassword}`
    )

    return {
      props: {
        title: 'Title',
        description: 'Desc',
      },
    }

    // const db = await myDB.connect({
    //   host: process.env.DB_HOST,
    //   username: process.env.DB_USER,
    //   password: process.env.DB_PASS,
    // })
  }
