import React from 'react'
import Layout from './Layout'

export default function Home() {
    return (
        <div>
            <Layout title={process.env.appName}/>
        </div>
    )
}
